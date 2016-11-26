package com.liuzhf.data.entity;

/**
 * Created by asus on 2016/11/19.
 */
public class DataFeatured {
    private String mDate;
    private float mCurrentPrice, mAvgPrice5m, mAvgPrice15m, mAvgPrice30m, mAvgPrice60m, mAvgPrice2h, mAvgPrice1d, mAvgPrice2d, mAvgPrice4d, mAvgPrice8d, mAvgPrice16d, mAvgPrice32d, mAvgPrice64d, mAvgPrice128d, mAvgPrice256d, mAvgPrice512d;
    private boolean mIsUp;

    public DataFeatured(String date, float mCurrentPrice, float mAvgPrice5m, float mAvgPrice15m, float mAvgPrice30m, float mAvgPrice60m, float mAvgPrice2h, float mAvgPrice1d, float mAvgPrice2d, float mAvgPrice4d, float mAvgPrice8d, float mAvgPrice16d, float mAvgPrice32d, float mAvgPrice64d, float mAvgPrice128d, float mAvgPrice256d, float mAvgPrice512d, boolean isUp) {
        this.mDate = date;
        this.mCurrentPrice = mCurrentPrice;
        this.mAvgPrice5m = mAvgPrice5m;
        this.mAvgPrice15m = mAvgPrice15m;
        this.mAvgPrice30m = mAvgPrice30m;
        this.mAvgPrice60m = mAvgPrice60m;
        this.mAvgPrice2h = mAvgPrice2h;
        this.mAvgPrice1d = mAvgPrice1d;
        this.mAvgPrice2d = mAvgPrice2d;
        this.mAvgPrice4d = mAvgPrice4d;
        this.mAvgPrice8d = mAvgPrice8d;
        this.mAvgPrice16d = mAvgPrice16d;
        this.mAvgPrice32d = mAvgPrice32d;
        this.mAvgPrice64d = mAvgPrice64d;
        this.mAvgPrice128d = mAvgPrice128d;
        this.mAvgPrice256d = mAvgPrice256d;
        this.mAvgPrice512d = mAvgPrice512d;
        this.mIsUp = isUp;
    }

    public float getmCurrentPrice() {
        return mCurrentPrice;
    }

    public void setmCurrentPrice(float mCurrentPrice) {
        this.mCurrentPrice = mCurrentPrice;
    }

    public float getmAvgPrice5m() {
        return mAvgPrice5m;
    }

    public void setmAvgPrice5m(float mAvgPrice5m) {
        this.mAvgPrice5m = mAvgPrice5m;
    }

    public float getmAvgPrice15m() {
        return mAvgPrice15m;
    }

    public void setmAvgPrice15m(float mAvgPrice15m) {
        this.mAvgPrice15m = mAvgPrice15m;
    }

    public float getmAvgPrice30m() {
        return mAvgPrice30m;
    }

    public void setmAvgPrice30m(float mAvgPrice30m) {
        this.mAvgPrice30m = mAvgPrice30m;
    }

    public float getmAvgPrice60m() {
        return mAvgPrice60m;
    }

    public void setmAvgPrice60m(float mAvgPrice60m) {
        this.mAvgPrice60m = mAvgPrice60m;
    }

    public float getmAvgPrice2h() {
        return mAvgPrice2h;
    }

    public void setmAvgPrice2h(float mAvgPrice2h) {
        this.mAvgPrice2h = mAvgPrice2h;
    }

    public float getmAvgPrice1d() {
        return mAvgPrice1d;
    }

    public void setmAvgPrice1d(float mAvgPrice1d) {
        this.mAvgPrice1d = mAvgPrice1d;
    }

    public float getmAvgPrice2d() {
        return mAvgPrice2d;
    }

    public void setmAvgPrice2d(float mAvgPrice2d) {
        this.mAvgPrice2d = mAvgPrice2d;
    }

    public float getmAvgPrice4d() {
        return mAvgPrice4d;
    }

    public void setmAvgPrice4d(float mAvgPrice4d) {
        this.mAvgPrice4d = mAvgPrice4d;
    }

    public float getmAvgPrice8d() {
        return mAvgPrice8d;
    }

    public void setmAvgPrice8d(float mAvgPrice8d) {
        this.mAvgPrice8d = mAvgPrice8d;
    }

    public float getmAvgPrice16d() {
        return mAvgPrice16d;
    }

    public void setmAvgPrice16d(float mAvgPrice16d) {
        this.mAvgPrice16d = mAvgPrice16d;
    }

    public float getmAvgPrice32d() {
        return mAvgPrice32d;
    }

    public void setmAvgPrice32d(float mAvgPrice32d) {
        this.mAvgPrice32d = mAvgPrice32d;
    }

    public float getmAvgPrice64d() {
        return mAvgPrice64d;
    }

    public void setmAvgPrice64d(float mAvgPrice64d) {
        this.mAvgPrice64d = mAvgPrice64d;
    }

    public float getmAvgPrice128d() {
        return mAvgPrice128d;
    }

    public void setmAvgPrice128d(float mAvgPrice128d) {
        this.mAvgPrice128d = mAvgPrice128d;
    }

    public float getmAvgPrice256d() {
        return mAvgPrice256d;
    }

    public void setmAvgPrice256d(float mAvgPrice256d) {
        this.mAvgPrice256d = mAvgPrice256d;
    }

    public float getmAvgPrice512d() {
        return mAvgPrice512d;
    }

    public void setmAvgPrice512d(float mAvgPrice512d) {
        this.mAvgPrice512d = mAvgPrice512d;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public boolean ismIsUp() {
        return mIsUp;
    }

    public void setmIsUp(boolean mIsUp) {
        this.mIsUp = mIsUp;
    }

    @Override
    public String toString() {
        return mDate + " >>> " + this.mIsUp;
    }
}