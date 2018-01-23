package resources;

import io.dropwizard.servlets.assets.ResourceNotFoundException;
import model.CompanyDay;
import model.Exchanges;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Get live-stats for one day (either current or yester).
 */
@Path("/exchanges/{/name}{/company}{/day}")
@Produces(MediaType.APPLICATION_JSON)
public class DirectoryStatsDay
{
    private Exchanges exchanges;

    public DirectoryStatsDay(Exchanges exchanges)
    {
        this.exchanges = exchanges;
    }

    @GET
    public CompanyDay getStats(@PathParam("name") String name,
                               @PathParam("company") String company,
                               @PathParam("day") String day) {
        if(day.equals("yesterday") || day.equals("today"))
        {
            if (exchanges.getExchanges().containsKey(name))
            {
                if(exchanges.getExchanges()
                            .get(name)
                            .getCompanies()
                            .containsKey(company))
                {
                    CompanyDay result;
                    if(day.equals("today")) {
                        result = exchanges.getExchanges()
                                          .get(name)
                                          .getCompanies()
                                          .get(company).createDay(true);
                    }
                    else {
                        result = exchanges.getExchanges()
                                              .get(name)
                                              .getCompanies()
                                              .get(company)
                                              .createDay(false);
                    }
                    return result;
                }
            }
        }
        throw new ResourceNotFoundException(new WebApplicationException());
    }
}
