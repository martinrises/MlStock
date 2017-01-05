package com.liuzhf.data.util.avg;

import com.liuzhf.data.entity.RawDataItem;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class AvgComputorClosePriceForMin extends AvgComputor<RawDataItem, Float> {

    public AvgComputorClosePriceForMin(List<? extends RawDataItem> items) {
        this.mItems = items;
    }
    @Override
    protected Float getFieldForAvg(int index) {
        return mItems.get(index).getmClosingPx();
    }

    @Override
    protected Float doAdd(Float sum, int index) {
        return sum + getFieldForAvg(index);
    }

    @Override
    protected Float doDivide(Float sum, int cnt) {
        return sum/cnt;
    }

    @Override
    protected Float getAvgNull() {
        return 0f;
    }

}
