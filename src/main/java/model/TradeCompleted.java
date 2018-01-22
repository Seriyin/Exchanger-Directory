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
    private int quant;
    private float total;
    private String user;
    private long timestamp;

    @JsonCreator
    public TradeCompleted(@JsonProperty("exchange") String exchange,
                          @JsonProperty("company") String company,
                          @JsonProperty("quant") int quant,
                          @JsonProperty("total") float total,
                          @JsonProperty("user") String user,
                          @JsonProperty("timestamp") long timestamp)
    {
        this.exchange = exchange;
        this.company = company;
        this.quant = quant;
        this.total = total;
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
    public int getQuant()
    {
        return quant;
    }

    @JsonProperty
    public float getTotal()
    {
        return total;
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
