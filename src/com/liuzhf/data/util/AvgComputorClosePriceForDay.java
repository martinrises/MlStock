package com.liuzhf.data.util;

import com.liuzhf.data.entity.DataPerDay;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class AvgComputorClosePriceForDay extends AvgComputorForDay<Float> {

    public AvgComputorClosePriceForDay(List<DataPerDay> items) {
        this.mDataForDays = items;
    }

    @Override
    protected Float getFieldForAvg(int index) {
        return mDataForDays.get(index).getClosePrice();
    }

    @Override
    protected Float doAdd(Float sum, int index) {
        return sum + mDataForDays.get(index).getClosePrice();
    }

    @Override
    protected Float doDivide(Float sum, int cnt) {
        return sum / cnt;
    }
}
