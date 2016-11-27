package com.liuzhf.data.util.avg;

import com.liuzhf.data.entity.DataPerDay;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class AvgComputorVolumeForDay extends AvgComputor<DataPerDay, Double> {

    public AvgComputorVolumeForDay(List<DataPerDay> items) {
        this.mItems = items;
    }

    @Override
    protected Double getFieldForAvg(int index) {
        return mItems.get(index).getTotalVolumeTraded();
    }

    @Override
    protected Double doAdd(Double sum, int index) {
        return sum + mItems.get(index).getTotalVolumeTraded();
    }

    @Override
    protected Double doDivide(Double sum, int cnt) {
        return sum / cnt;
    }

    @Override
    protected Double getAvgNull() {
        return 0d;
    }
}
