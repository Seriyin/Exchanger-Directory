package resources;

import model.Companies;
import model.Exchange;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Resource to GET all companies traded and in what exchange.
 */
@Path("/companies")
@Produces(MediaType.APPLICATION_JSON)
public class DirectoryCompanies
{
    private Companies companies;

    public DirectoryCompanies(Companies companies)
    {
        this.companies = companies;
    }

    @GET
    public Map<String, String> getCompanies() {
        return companies.getCompanies()
                        .entrySet()
                        .stream()
                        .map(e -> new AbstractMap.SimpleImmutableEntry<>(e.getKey(), e.getValue().getName()))
                        .collect(Collectors.toMap(AbstractMap.SimpleImmutableEntry::getKey, AbstractMap.SimpleImmutableEntry::getValue));
    }
}
