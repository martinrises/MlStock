package com.liuzhf.data.util.avg;

import com.liuzhf.data.entity.DataPerDay;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class AvgComputorClosePriceForDay extends AvgComputor<DataPerDay, Float> {

    public AvgComputorClosePriceForDay(List<DataPerDay> items) {
        this.mItems = items;
    }

    @Override
    protected Float getFieldForAvg(int index) {
        return mItems.get(index).getClosePrice();
    }

    @Override
    protected Float doAdd(Float sum, int index) {
        return sum + mItems.get(index).getClosePrice();
    }

    @Override
    protected Float doDivide(Float sum, int cnt) {
        return sum / cnt;
    }

    @Override
    protected Float getAvgNull() {
        return 0f;
    }
}
