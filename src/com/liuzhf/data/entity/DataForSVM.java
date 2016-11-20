package com.liuzhf.data.entity;

/**
 * Created by asus on 2016/11/19.
 */
public class DataForSVM {
    private float[] mPrices;
    private boolean mIsUp;

    public DataForSVM(boolean isUp, float... prices) {
        mIsUp = isUp;
        mPrices = prices;
    }

    public boolean isUp() {
        return mIsUp;
    }
}
