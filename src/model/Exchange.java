package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.InetSocketAddress;
import java.util.Map;

/**
 * Exchange contains company information, it's name and whether
 * it is online and on what address it is reachable.
 */
public class Exchange
{
    private boolean online;
    private InetSocketAddress at;
    private String name;
    private Map<String,Company> companies;

    @JsonProperty
    public boolean isOnline()
    {
        return online;
    }

    @JsonProperty
    public void setOnline(boolean online)
    {
        this.online = online;
    }

    @JsonProperty
    public InetSocketAddress getAt()
    {
        return at;
    }

    @JsonProperty
    public void setAt(InetSocketAddress at) {
        this.at = at;
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }

    @JsonProperty
    public void setName(String name)
    {
        this.name = name;
    }

    @JsonProperty
    public Map<String, Company> getCompanies()
    {
        return companies;
    }

    @JsonProperty
    public void setCompanies(Map<String, Company> companies)
    {
        this.companies = companies;
    }
}
