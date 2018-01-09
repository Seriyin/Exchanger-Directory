package resources;

import io.dropwizard.servlets.assets.ResourceNotFoundException;
import model.Company;
import model.Exchanges;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Gets the live-stats for a company's trading in a given exchange.
 */
@Path("/exchanges/{/name}{/company}")
@Produces(MediaType.APPLICATION_JSON)
public class DirectoryStats
{
    private Exchanges exchanges;

    public DirectoryStats(Exchanges exchanges)
    {
        this.exchanges = exchanges;
    }

    @GET
    public Company getStats(@PathParam("name") String name,
                            @PathParam("company") String company) {
        if (exchanges.getExchanges().containsKey(name))
        {
            if(exchanges.getExchanges()
                        .get(name)
                        .getCompanies()
                        .containsKey(company))
            {
                return exchanges.getExchanges()
                                .get(name)
                                .getCompanies()
                                .get(company);
            }
        }
        throw new ResourceNotFoundException(new WebApplicationException());
    }
}