package pt.um.exchanger.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import pt.um.exchanger.model.Exchanges;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * DirectoryConfig loads up the exchanges known from the YAML config file provided.
 */
public class DirectoryConfig extends Configuration
{
    private Exchanges exchanges;

    @JsonProperty
    public Exchanges getExchanges() {
        return exchanges;
    }

    @JsonProperty
    public void setExchanges(Exchanges exchanges) {
        this.exchanges = exchanges;
    }

}