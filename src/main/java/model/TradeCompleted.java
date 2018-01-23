package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TradeCompleted POJO of a JSON request to update company info.
 */
public class TradeCompleted
{
    private String exchange;
    private String company;
    private double peak;
    private String user;
    private long timestamp;

    @JsonCreator
    public TradeCompleted(@JsonProperty("exchange") String exchange,
                          @JsonProperty("company") String company,
                          @JsonProperty("peak") double peak,
                          @JsonProperty("user") String user,
                          @JsonProperty("timestamp") long timestamp)
    {
        this.exchange = exchange;
        this.company = company;
        this.peak = peak;
        this.user = user;
        this.timestamp = timestamp;
    }

    @JsonProperty
    public String getExchange()
    {
        return exchange;
    }

    @JsonProperty
    public String getCompany()
    {
        return company;
    }

    @JsonProperty
    public double getPeak()
    {
        return peak;
    }

    @JsonProperty
    public String getUser()
    {
        return user;
    }

    @JsonProperty
    public long getTimestamp()
    {
        return timestamp;
    }
}
