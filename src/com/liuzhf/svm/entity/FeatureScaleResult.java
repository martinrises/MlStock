package com.liuzhf.svm.entity;

import com.liuzhf.data.entity.DataForSVM;

import java.util.List;

/**
 * Created by asus on 2016/11/26.
 */
public class FeatureScaleResult {
    private List<DataForSVM> mDataScaled;
    private FeatureScale mFeatureScale;

    public FeatureScaleResult(List<DataForSVM> dataScaled, FeatureScale featureScale) {
        this.mDataScaled = dataScaled;
        this.mFeatureScale = featureScale;
    }

    public List<DataForSVM> getmDataScaled() {
        return mDataScaled;
    }

    public void setmDataScaled(List<DataForSVM> mDataScaled) {
        this.mDataScaled = mDataScaled;
    }

    public FeatureScale getmFeatureScale() {
        return mFeatureScale;
    }

    public void setmFeatureScale(FeatureScale mFeatureScale) {
        this.mFeatureScale = mFeatureScale;
    }
}
