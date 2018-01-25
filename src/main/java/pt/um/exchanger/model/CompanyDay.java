package pt.um.exchanger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A company in a given day need only have it's name, and statistical information ({@link Stats}).
 */
public class CompanyDay
{
    private Stats day;
    private String name;

    @JsonCreator
    public CompanyDay(@JsonProperty("name") String name,
                      @JsonProperty("day") Stats day)
    {
        this.day = day;
        this.name = name;
    }

    @JsonProperty
    public Stats getDay()
    {
        return day;
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }
}
