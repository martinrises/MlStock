package com.liuzhf.data.util.avg;

import com.liuzhf.data.entity.RawDataItem;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class AvgComputorVolumeForMin extends AvgComputor<RawDataItem, Double> {

    public AvgComputorVolumeForMin(List<RawDataItem> items) {
        this.mItems = items;
    }
    @Override
    protected Double getFieldForAvg(int index) {
        return mItems.get(index).getmTotalVolumeTraded();
    }

    @Override
    protected Double doAdd(Double sum, int index) {
        return sum + getFieldForAvg(index);
    }

    @Override
    protected Double doDivide(Double sum, int cnt) {
        return sum/cnt;
    }

    @Override
    protected Double getAvgNull() {
        return 0d;
    }

}
