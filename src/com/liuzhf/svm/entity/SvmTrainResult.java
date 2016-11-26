package com.liuzhf.svm.entity;

import libsvm.svm_model;

/**
 * Created by asus on 2016/11/26.
 */
public class SvmTrainResult {

    private svm_model mModle;
    private FeatureScale mScale;

    public SvmTrainResult(svm_model model ,FeatureScale scale) {
        this.mModle = model;
        this.mScale = scale;
    }

    public svm_model getmModle() {
        return mModle;
    }

    public void setmModle(svm_model mModle) {
        this.mModle = mModle;
    }

    public FeatureScale getmScale() {
        return mScale;
    }

    public void setmScale(FeatureScale mScale) {
        this.mScale = mScale;
    }
}
