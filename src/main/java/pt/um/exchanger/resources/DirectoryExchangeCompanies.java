package pt.um.exchanger.resources;

import io.dropwizard.servlets.assets.ResourceNotFoundException;
import pt.um.exchanger.model.Exchanges;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * A resource that handles GETting all companies traded in a given exchange.
 */
@Path("/exchanges/{name}/companies")
@Produces(MediaType.APPLICATION_JSON)
public class DirectoryExchangeCompanies
{
    private Exchanges exchanges;

    public DirectoryExchangeCompanies(Exchanges exchanges)
    {
        this.exchanges = exchanges;
    }

    @GET
    public Set<String> getCompanies(@PathParam("name") String name) {
        if(exchanges.getExchanges()
                    .containsKey(name))
        {
            return exchanges.getExchanges()
                            .get(name)
                            .getCompanies()
                            .keySet();
        }
        else {
            throw new ResourceNotFoundException(
                    new WebApplicationException());
        }
    }
}
