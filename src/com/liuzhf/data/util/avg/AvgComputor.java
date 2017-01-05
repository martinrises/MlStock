package com.liuzhf.data.util.avg;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public abstract class AvgComputor<D, T extends Number> {
    protected List<? extends D> mItems;

    protected abstract T getFieldForAvg(int index);

    protected abstract T doAdd(T sum, int index);

    protected abstract T doDivide(T sum , int cnt);

    protected abstract T getAvgNull();

    public T getAvgFromStart(int startIndex, int cnt) {
        int end = startIndex + cnt;

        if(end > mItems.size()) {
            return getAvgNull();
        }

        T sum = getFieldForAvg(startIndex);
        for(int i = startIndex+1; i != end; i++) {
            sum = doAdd(sum, i);
        }

        return doDivide(sum, cnt);
    }

    public T getAvgFromEnd(int endIndex, int cnt) {
        int start = endIndex - cnt;

        if(start < -1) {
            return getAvgNull();
        }

        T sum = getFieldForAvg(endIndex);
        for(int i = endIndex - 1; i != start; i--){
            sum =doAdd(sum, i);
        }

        return doDivide(sum, cnt);
    }
}
