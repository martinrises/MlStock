package com.liuzhf.svm.entity;

/**
 * Created by asus on 2016/11/26.
 */
public class FeatureScale {
    private float mScaleRange;
    private float mMiddValue;

    public FeatureScale(float scaleRange, float middValue) {
        this.mScaleRange = scaleRange;
        this.mMiddValue = middValue;
    }

    public float getmScaleRange() {
        return mScaleRange;
    }

    public void setmScaleRange(float mScaleRange) {
        this.mScaleRange = mScaleRange;
    }

    public float getmMiddValue() {
        return mMiddValue;
    }

    public void setmMiddValue(float mMiddValue) {
        this.mMiddValue = mMiddValue;
    }
}
