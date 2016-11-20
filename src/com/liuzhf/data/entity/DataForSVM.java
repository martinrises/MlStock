package com.liuzhf.data.entity;

import java.util.Arrays;

/**
 * Created by asus on 2016/11/19.
 */
public class DataForSVM {
    private float[] mPrices;
    private boolean mIsUp;
    private String mDate;

    public DataForSVM(String date, boolean isUp, float... prices) {
        mDate = date;
        mIsUp = isUp;
        mPrices = prices;
    }

    public boolean isUp() {
        return mIsUp;
    }

    @Override
    public String toString() {
        return mDate + ", " + Arrays.toString(mPrices) + isUp();
    }
}
