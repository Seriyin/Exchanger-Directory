package pt.um.exchanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes the statistics required for live-monitoring of a company's stock trade performance for a specific day.
 */
public class Stats
{
    private Peak lowPeak;
    private Peak highPeak;
    private double openingPrice;
    private double closingPrice;

    /**
     * Initialize broken while there are no stats.
     */
    public Stats()
    {
        highPeak = new Peak(Double.NaN, 0);
        lowPeak = new Peak(Double.NaN, 0);
        openingPrice = Double.NaN;
        closingPrice = Double.NaN;
    }

    public synchronized void registerPeakHigh(double price, long time)
    {
        if(openingPrice == Double.NaN)
            setOpeningPrice(price);
        highPeak.registerPeakHigh(price, time);
    }

    public synchronized void registerPeakLow(double price, long time)
    {
        if(openingPrice == Double.NaN)
            setOpeningPrice(price);
        lowPeak.registerPeakLow(price, time);
    }

    @JsonProperty
    public Peak getHighPeak()
    {
        return highPeak.getImmutableCopy();
    }

    @JsonProperty
    public Peak getLowPeak()
    {
        return lowPeak.getImmutableCopy();
    }

    @JsonProperty
    public double getClosingPrice()
    {
        return closingPrice;
    }

    @JsonProperty
    public double getOpeningPrice()
    {
        return openingPrice;
    }

    @JsonProperty
    public void setOpeningPrice(double openingPrice)
    {
        this.openingPrice = openingPrice;
    }

    @JsonProperty
    public void setClosingPrice(double closingPrice)
    {
        this.closingPrice = closingPrice;
    }

    @JsonProperty
    public void setLowPeak(Peak lowPeak)
    {
        this.lowPeak = lowPeak;
    }

    @JsonProperty
    public void setHighPeak(Peak highPeak)
    {
        this.highPeak = highPeak;
    }
}
