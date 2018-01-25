package pt.um.exchanger.resources;

import io.dropwizard.servlets.assets.ResourceNotFoundException;
import pt.um.exchanger.model.Company;
import pt.um.exchanger.model.Exchange;
import pt.um.exchanger.model.Exchanges;
import pt.um.exchanger.model.TradeCompleted;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * Gets the live-stats for a company's trading in a given exchange.
 */
@Path("/exchanges/{name}/{company}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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

    @PUT
    public Response updateCompanyTrades(@PathParam("name") String name,
                                        @PathParam("company") String company,
                                        @Valid @NotNull TradeCompleted tc)
    {
        if(name.equals(tc.getExchange()) &&
           company.equals(tc.getCompany()))
        {
            if (exchanges.getExchanges().containsKey(name))
            {
                Exchange e = exchanges.getExchanges()
                                      .get(name);
                if(e.isOnline()) {
                    if(e.getCompanies()
                        .containsKey(company))
                    {
                        Company c = exchanges.getExchanges()
                                             .get(name)
                                             .getCompanies()
                                             .get(company);
                        c.updateStats(tc);
                        return Response.accepted(UriBuilder.fromResource(DirectoryStats.class)
                                                           .build(name,company))
                                       .build();
                    }
                }
                else {
                    throw new WebApplicationException("Exchange offline",
                                                      Response.Status.FORBIDDEN);
                }
            }
        }
        throw new ResourceNotFoundException(new WebApplicationException());
    }
}