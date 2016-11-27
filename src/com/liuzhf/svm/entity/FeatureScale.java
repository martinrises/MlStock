package com.liuzhf.svm.entity;

/**
 * Created by asus on 2016/11/26.
 */
public class FeatureScale {
    private double mScaleRange;
    private double mMiddValue;

    public FeatureScale(double scaleRange, double middValue) {
        this.mScaleRange = scaleRange;
        this.mMiddValue = middValue;
    }

    public double getmScaleRange() {
        return mScaleRange;
    }

    public void setmScaleRange(float mScaleRange) {
        this.mScaleRange = mScaleRange;
    }

    public double getmMiddValue() {
        return mMiddValue;
    }

    public void setmMiddValue(float mMiddValue) {
        this.mMiddValue = mMiddValue;
    }
}
