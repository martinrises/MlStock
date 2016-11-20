package com.liuzhf.data.util;

import com.liuzhf.data.entity.RawDataItem;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public abstract class AvgComputor<T extends Number> {
    protected List<RawDataItem> mItems;
    protected int mCnt;

    protected abstract T getFieldForAvg(int index);

    protected abstract T doAdd(T sum, int index);

    protected abstract T doDivide();

    public T getAvgFromStart(int startIndex) {
        int end = startIndex + mCnt;

        if(end > mItems.size()) {
            return null;
        }

        T sum = getFieldForAvg(startIndex);
        for(int i = startIndex+1; i != end; i++) {
            doAdd(sum, i);
        }

        return doDivide();
    }

    public T getAvgFromEnd(int endIndex) {
        int start = endIndex - mCnt;

        if(start < -1) {
            return null;
        }

        T sum = getFieldForAvg(endIndex);
        for(int i = endIndex - 1; i != start; i--){
            doAdd(sum, i);
        }

        return doDivide();
    }
}
