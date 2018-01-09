import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A company need only have it's name, current and older statistical information ({@link Stats}) and whether it's currently live (means someone has traded on it for the current day).
 */
public class Company
{
    private String name;
    private boolean live;
    private Stats yesterday;
    private Stats today;

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
    public boolean isLive()
    {
        return live;
    }

    @JsonProperty
    public void setLive(boolean live)
    {
        this.live = live;
    }

    @JsonProperty
    public Stats getStats(boolean current) {
        Stats result;
        if(current) {
            return today;
        }
        else
            return yesterday;
    }
}
