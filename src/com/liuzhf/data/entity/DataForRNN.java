package com.liuzhf.data.entity;

/**
 * Created by asus on 2017/1/2.
 */
public class DataForRNN {

    private DataPerDay mDataPerDay;
    private int mLable;

    public DataForRNN(DataPerDay mDataPerDay, int mLable) {
        this.mDataPerDay = mDataPerDay;
        this.mLable = mLable;
    }

    public DataPerDay getmDataPerDay() {
        return mDataPerDay;
    }

    public void setmDataPerDay(DataPerDay mDataPerDay) {
        this.mDataPerDay = mDataPerDay;
    }

    public int getmLable() {
        return mLable;
    }

    public void setmLable(int mLable) {
        this.mLable = mLable;
    }

    public String getDate() {
        return this.mDataPerDay.getDate();
    }
}
