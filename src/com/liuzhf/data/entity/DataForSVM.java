package com.liuzhf.data.entity;

import java.util.Arrays;

/**
 * Created by asus on 2016/11/19.
 */
public class DataForSVM {
    private float[] mFeatures;
    private boolean mIsUp;
    private String mDate;

    public DataForSVM(String date, boolean isUp, float... prices) {
        mDate = date;
        mIsUp = isUp;
        mFeatures = prices;
    }

    public boolean isUp() {
        return mIsUp;
    }

    public float[] getFeatures() {
        return this.mFeatures;
    }

    @Override
    public String toString() {
        return mDate + ", " + Arrays.toString(mFeatures) + isUp();
    }
}
