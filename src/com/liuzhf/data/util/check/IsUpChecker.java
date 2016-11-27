package com.liuzhf.data.util.check;

import com.liuzhf.data.entity.DataPerDay;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class IsUpChecker {

    private static final float SCALE = 0.2f;

    private List<DataPerDay> mDataPerDays;

    public IsUpChecker(List<DataPerDay> mDataPerDays) {
        this.mDataPerDays = mDataPerDays;
    }

    public boolean isUp(int index, int daysAfter) {
        if(index - daysAfter < 0 || index + daysAfter >= mDataPerDays.size() ) {
            return false;
        }

        float highPrice = Float.MIN_VALUE;
        float lowPrice = Float.MAX_VALUE;
        for(int i = index; i < index + 5; i++) {
            DataPerDay dataPerDay = mDataPerDays.get(i);
            highPrice = Math.max(highPrice, dataPerDay.getHighPrice());
            lowPrice = Math.min(lowPrice, dataPerDay.getLowPrice());
        }

        return ((mDataPerDays.get(index + daysAfter).getClosePrice() - mDataPerDays.get(index).getClosePrice()) > ((highPrice - lowPrice) * SCALE));
    }
}
