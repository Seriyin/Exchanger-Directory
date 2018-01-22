package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Companies provides an alternate view, collapsed in companies into their exchanges.
 */
public class Companies
{
    private Map<String,Exchange> companies;

    public Companies(Exchanges exchanges)
    {
        companies = new HashMap<>();
        exchanges.getExchanges()
                 .values()
                 .forEach(e -> e.getCompanies()
                                .keySet()
                                .stream()
                                .forEach(c -> companies.put(c,e)));
    }

    @JsonProperty
    public Map<String, Exchange> getCompanies()
    {
        return companies;
    }
}
