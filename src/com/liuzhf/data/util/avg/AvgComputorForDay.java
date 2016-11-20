package com.liuzhf.data.util.avg;

import com.liuzhf.data.entity.DataPerDay;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public abstract class AvgComputorForDay<T> {
    protected List<DataPerDay> mDataForDays;

    protected abstract T getFieldForAvg(int index);

    protected abstract T doAdd(T sum, int index);

    protected abstract T doDivide(T sum , int cnt);

    public T getAvgFromStart(int startIndex, int cnt) {
        int end = startIndex + cnt;

        if(end > mDataForDays.size()) {
            return null;
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
            return null;
        }

        T sum = getFieldForAvg(endIndex);
        for(int i = endIndex - 1; i != start; i--){
            sum =doAdd(sum, i);
        }

        return doDivide(sum, cnt);
    }
}
