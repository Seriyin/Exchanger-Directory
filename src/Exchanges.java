import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * Exchanges houses all the exchange objects and allows easy look-up
 * over exchanges (not to far from simple POJO).
 */
public class Exchanges
{
    private Map<String, Exchange> exchanges;

    @JsonProperty
    public Map<String, Exchange> getExchanges()
    {
        return exchanges;
    }

    @JsonProperty
    public void setExchanges(Map<String, Exchange> exchanges)
    {
        this.exchanges = exchanges;
    }
}
