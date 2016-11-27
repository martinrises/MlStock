package com.liuzhf.data.entity;

import java.util.Arrays;

/**
 * Created by asus on 2016/11/19.
 */
public class DataForSVM {
    private double[] mFeatures;
    private boolean mIsUp;
    private String mDate;

    public DataForSVM(String date, boolean isUp, double... prices) {
        mDate = date;
        mIsUp = isUp;
        mFeatures = prices;
    }

    public boolean isUp() {
        return mIsUp;
    }

    public String getDate() {
        return mDate;
    }

    public double[] getFeatures() {
        return this.mFeatures;
    }

    @Override
    public String toString() {
        return mDate + ", " + Arrays.toString(mFeatures) + isUp();
    }
}
