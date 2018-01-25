package pt.um.exchanger.resources;

import io.dropwizard.servlets.assets.ResourceNotFoundException;
import pt.um.exchanger.model.Address;
import pt.um.exchanger.model.Exchanges;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The main global listing of exchanges URL resource.
 */
@Path("/exchanges")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DirectoryExchanges
{
    private Exchanges exchanges;

    public DirectoryExchanges(Exchanges exchanges)
    {
        this.exchanges = exchanges;
    }


    @GET
    public Map<String, Set<String>> getExchanges() {
        return exchanges.getExchanges()
                 .entrySet()
                 .stream()
                 .map(e -> new AbstractMap.SimpleImmutableEntry<>(e.getKey(), e.getValue().getCompanies().keySet()))
                 .collect(Collectors.toMap(AbstractMap.SimpleImmutableEntry::getKey, AbstractMap.SimpleImmutableEntry::getValue));
    }

    @PUT
    public Response updateExchanges(@Valid @NotNull Address ex) {
        Response ret;
        if (exchanges.getExchanges().containsKey(ex.getName()))
        {
            exchanges.getExchanges().get(ex.getName()).statusUpdate(ex);
            ret = Response.accepted(UriBuilder.fromResource(DirectoryExchanges.class)
                                              .build())
                          .build();
        }
        throw new ResourceNotFoundException(new WebApplicationException());
    }
}
