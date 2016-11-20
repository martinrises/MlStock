package com.liuzhf.data.util.avg;

import com.liuzhf.data.entity.RawDataItem;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class AvgComputorClosePriceForMin extends AvgComputorForMin<Float> {

    public AvgComputorClosePriceForMin(List<RawDataItem> items) {
        this.mRawItems = items;
    }
    @Override
    protected Float getFieldForAvg(int index) {
        return mRawItems.get(index).getmClosingPx();
    }

    @Override
    protected Float doAdd(Float sum, int index) {
        return sum + getFieldForAvg(index);
    }

    @Override
    protected Float doDivide(Float sum, int cnt) {
        return sum/cnt;
    }

}
