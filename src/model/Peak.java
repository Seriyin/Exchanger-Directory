package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A price-timestamp pair to record a peak price trade event.
 */
public class Peak
{
    private double peakPricePerStock;
    private long pricePeakTime;

    public Peak(double peakPricePerStock, long pricePeakTime)
    {
        this.peakPricePerStock = peakPricePerStock;
        this.pricePeakTime = pricePeakTime;
    }

    @JsonProperty
    public synchronized Peak getImmutableCopy()
    {
        return new Peak(peakPricePerStock,pricePeakTime);
    }


    public synchronized void registerPeakHigh(double price, long time)
    {
        if(peakPricePerStock == Double.NaN || price > peakPricePerStock)
        {
            peakPricePerStock = price;
            pricePeakTime = time;
        }
    }

    public synchronized void registerPeakLow(double price, long time)
    {
        if(peakPricePerStock == Double.NaN || price < peakPricePerStock)
        {
            peakPricePerStock = price;
            pricePeakTime = time;
        }
    }
}
