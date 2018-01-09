package resources;

import model.Exchanges;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The main global listing of exchanges URL resource.
 */
@Path("/exchanges")
@Produces(MediaType.APPLICATION_JSON)
public class DirectoryExchanges
{
    private Exchanges exchanges;

    public DirectoryExchanges(Exchanges exchanges)
    {
        this.exchanges = exchanges;
    }


    @GET
    public Map<String, String> getExchanges() {
        return exchanges.getExchanges()
                 .entrySet()
                 .stream()
                 .map(e -> new AbstractMap.SimpleImmutableEntry<String,String>(e.getKey(), e.getValue().getName()))
                 .collect(Collectors.toMap(AbstractMap.SimpleImmutableEntry::getKey,
                                           AbstractMap.SimpleImmutableEntry::getValue));
    }
}
