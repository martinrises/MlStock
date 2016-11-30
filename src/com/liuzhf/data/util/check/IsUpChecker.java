package com.liuzhf.data.util.check;

import com.liuzhf.data.entity.DataPerDay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2016/11/20.
 */
public class IsUpChecker {

    private static final float SCALE = 0.3f;
    public static final String KEY_HIGH_PX = "high_price";
    public static final String KEY_LOW_PX = "low_price";

    private List<DataPerDay> mDataPerDays;

    public IsUpChecker(List<DataPerDay> mDataPerDays) {
        this.mDataPerDays = mDataPerDays;
    }

    /*
    从以前到现在
     */
    public boolean isUp(int index, int daysAfter) {
        if(index - daysAfter < 0 || index + daysAfter >= mDataPerDays.size() ) {
            return false;
        }

        Map<String, Float> priceRange = getPriceRange(index, daysAfter);
        float highPrice = priceRange.get(KEY_HIGH_PX);
        float lowPrice = priceRange.get(KEY_LOW_PX);

        return getPriceDiff(index, daysAfter) > ((highPrice - lowPrice) * SCALE);
    }

    public Map<String, Float> getPriceRange(int index, int daysBefore) {
        float highPrice = Float.MIN_VALUE;
        float lowPrice = Float.MAX_VALUE;
        for(int i = index; i > index - daysBefore; i--) {
            DataPerDay dataPerDay = mDataPerDays.get(i);
            highPrice = Math.max(highPrice, dataPerDay.getHighPrice());
            lowPrice = Math.min(lowPrice, dataPerDay.getLowPrice());
        }
        HashMap<String, Float> result = new HashMap<>();
        result.put(KEY_LOW_PX, lowPrice);
        result.put(KEY_HIGH_PX, highPrice);
        return result;
    }

    public float getPriceDiff(int index, int daysAfter) {
        return mDataPerDays.get(index + daysAfter).getClosePrice() - mDataPerDays.get(index).getClosePrice();
    }
}
