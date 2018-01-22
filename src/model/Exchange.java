package model;

import com.fasterxml.jackson.annotation.JsonCreator;
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

    @JsonCreator
    public Exchange(@JsonProperty("online") boolean online,
                    @JsonProperty("at") InetSocketAddress at,
                    @JsonProperty("name") String name,
                    @JsonProperty("companies") Map<String, Company> companies)
    {
        this.online = online;
        this.at = at;
        this.name = name;
        this.companies = companies;
    }

    @JsonProperty
    public boolean isOnline()
    {
        return online;
    }

    @JsonProperty
    public InetSocketAddress getAt()
    {
        return at;
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }

    @JsonProperty
    public Map<String, Company> getCompanies()
    {
        return companies;
    }

    public void goOnline(Address ad) {
        online = true;
        at = new InetSocketAddress(ad.getHost(), ad.getPort());
    }
}
