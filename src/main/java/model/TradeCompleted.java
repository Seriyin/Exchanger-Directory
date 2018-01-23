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
    private boolean lowOrHigh;

    @JsonCreator
    public TradeCompleted(@JsonProperty("exchange") String exchange,
                          @JsonProperty("company") String company,
                          @JsonProperty("peak") double peak,
                          @JsonProperty("user") String user,
                          @JsonProperty("timestamp") long timestamp,
                          @JsonProperty("lowOrHigh") boolean lowOrHigh)
    {
        this.exchange = exchange;
        this.company = company;
        this.peak = peak;
        this.user = user;
        this.timestamp = timestamp;
        this.lowOrHigh = lowOrHigh;
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

    @JsonProperty
    public boolean isLowOrHigh()
    {
        return lowOrHigh;
    }
}
