package com.liuzhf.data.entity;

/**
 * Created by asus on 2016/11/19.
 */
public class DataFeatured {
    private String mDate;
    private float mCurrentPrice, mAvgPrice5m, mAvgPrice15m, mAvgPrice30m, mAvgPrice60m, mAvgPrice2h, mAvgPrice1d, mAvgPrice2d, mAvgPrice4d, mAvgPrice8d, mAvgPrice16d, mAvgPrice32d, mAvgPrice64d, mAvgPrice128d, mAvgPrice256d, mAvgPrice512d;
    private double mCurrentVolume, mAvgVolume5m, mAvgVolume15m, mAvgVolume30m, mAvgVolume60m, mAvgVolume2h, mAvgVolume1d, mAvgVolume2d, mAvgVolume4d, mAvgVolume8d, mAvgVolume16d, mAvgVolume32d, mAvgVolume64d, mAvgVolume128d, mAvgVolume256d, mAvgVolume512d;
    private boolean mIsUp;

    public DataFeatured(String mDate, float mCurrentPrice, float mAvgPrice5m, float mAvgPrice15m, float mAvgPrice30m, float mAvgPrice60m, float mAvgPrice2h, float mAvgPrice1d, float mAvgPrice2d, float mAvgPrice4d, float mAvgPrice8d, float mAvgPrice16d, float mAvgPrice32d, float mAvgPrice64d, float mAvgPrice128d, float mAvgPrice256d, float mAvgPrice512d, double mCurrentVolume, double mAvgVolume5m, double mAvgVolume15m, double mAvgVolume30m, double mAvgVolume60m, double mAvgVolume2h, double mAvgVolume1d, double mAvgVolume2d, double mAvgVolume4d, double mAvgVolume8d, double mAvgVolume16d, double mAvgVolume32d, double mAvgVolume64d, double mAvgVolume128d, double mAvgVolume256d, double mAvgVolume512d, boolean mIsUp) {
        this.mDate = mDate;
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
        this.mCurrentVolume = mCurrentVolume;
        this.mAvgVolume5m = mAvgVolume5m;
        this.mAvgVolume15m = mAvgVolume15m;
        this.mAvgVolume30m = mAvgVolume30m;
        this.mAvgVolume60m = mAvgVolume60m;
        this.mAvgVolume2h = mAvgVolume2h;
        this.mAvgVolume1d = mAvgVolume1d;
        this.mAvgVolume2d = mAvgVolume2d;
        this.mAvgVolume4d = mAvgVolume4d;
        this.mAvgVolume8d = mAvgVolume8d;
        this.mAvgVolume16d = mAvgVolume16d;
        this.mAvgVolume32d = mAvgVolume32d;
        this.mAvgVolume64d = mAvgVolume64d;
        this.mAvgVolume128d = mAvgVolume128d;
        this.mAvgVolume256d = mAvgVolume256d;
        this.mAvgVolume512d = mAvgVolume512d;
        this.mIsUp = mIsUp;
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

    public double getmCurrentVolume() {
        return mCurrentVolume;
    }

    public void setmCurrentVolume(double mCurrentVolume) {
        this.mCurrentVolume = mCurrentVolume;
    }

    public double getmAvgVolume5m() {
        return mAvgVolume5m;
    }

    public void setmAvgVolume5m(double mAvgVolume5m) {
        this.mAvgVolume5m = mAvgVolume5m;
    }

    public double getmAvgVolume15m() {
        return mAvgVolume15m;
    }

    public void setmAvgVolume15m(double mAvgVolume15m) {
        this.mAvgVolume15m = mAvgVolume15m;
    }

    public double getmAvgVolume30m() {
        return mAvgVolume30m;
    }

    public void setmAvgVolume30m(double mAvgVolume30m) {
        this.mAvgVolume30m = mAvgVolume30m;
    }

    public double getmAvgVolume60m() {
        return mAvgVolume60m;
    }

    public void setmAvgVolume60m(double mAvgVolume60m) {
        this.mAvgVolume60m = mAvgVolume60m;
    }

    public double getmAvgVolume2h() {
        return mAvgVolume2h;
    }

    public void setmAvgVolume2h(double mAvgVolume2h) {
        this.mAvgVolume2h = mAvgVolume2h;
    }

    public double getmAvgVolume1d() {
        return mAvgVolume1d;
    }

    public void setmAvgVolume1d(double mAvgVolume1d) {
        this.mAvgVolume1d = mAvgVolume1d;
    }

    public double getmAvgVolume2d() {
        return mAvgVolume2d;
    }

    public void setmAvgVolume2d(double mAvgVolume2d) {
        this.mAvgVolume2d = mAvgVolume2d;
    }

    public double getmAvgVolume4d() {
        return mAvgVolume4d;
    }

    public void setmAvgVolume4d(double mAvgVolume4d) {
        this.mAvgVolume4d = mAvgVolume4d;
    }

    public double getmAvgVolume8d() {
        return mAvgVolume8d;
    }

    public void setmAvgVolume8d(double mAvgVolume8d) {
        this.mAvgVolume8d = mAvgVolume8d;
    }

    public double getmAvgVolume16d() {
        return mAvgVolume16d;
    }

    public void setmAvgVolume16d(double mAvgVolume16d) {
        this.mAvgVolume16d = mAvgVolume16d;
    }

    public double getmAvgVolume32d() {
        return mAvgVolume32d;
    }

    public void setmAvgVolume32d(double mAvgVolume32d) {
        this.mAvgVolume32d = mAvgVolume32d;
    }

    public double getmAvgVolume64d() {
        return mAvgVolume64d;
    }

    public void setmAvgVolume64d(double mAvgVolume64d) {
        this.mAvgVolume64d = mAvgVolume64d;
    }

    public double getmAvgVolume128d() {
        return mAvgVolume128d;
    }

    public void setmAvgVolume128d(double mAvgVolume128d) {
        this.mAvgVolume128d = mAvgVolume128d;
    }

    public double getmAvgVolume256d() {
        return mAvgVolume256d;
    }

    public void setmAvgVolume256d(double mAvgVolume256d) {
        this.mAvgVolume256d = mAvgVolume256d;
    }

    public double getmAvgVolume512d() {
        return mAvgVolume512d;
    }

    public void setmAvgVolume512d(double mAvgVolume512d) {
        this.mAvgVolume512d = mAvgVolume512d;
    }

    @Override
    public String toString() {
        return "DataFeatured{" +
                "mDate='" + mDate + '\'' +
                ", mCurrentPrice=" + mCurrentPrice +
                ", mAvgPrice5m=" + mAvgPrice5m +
                ", mAvgPrice15m=" + mAvgPrice15m +
                ", mAvgPrice30m=" + mAvgPrice30m +
                ", mAvgPrice60m=" + mAvgPrice60m +
                ", mAvgPrice2h=" + mAvgPrice2h +
                ", mAvgPrice1d=" + mAvgPrice1d +
                ", mAvgPrice2d=" + mAvgPrice2d +
                ", mAvgPrice4d=" + mAvgPrice4d +
                ", mAvgPrice8d=" + mAvgPrice8d +
                ", mAvgPrice16d=" + mAvgPrice16d +
                ", mAvgPrice32d=" + mAvgPrice32d +
                ", mAvgPrice64d=" + mAvgPrice64d +
                ", mAvgPrice128d=" + mAvgPrice128d +
                ", mAvgPrice256d=" + mAvgPrice256d +
                ", mAvgPrice512d=" + mAvgPrice512d +
                ", mIsUp=" + mIsUp +
                '}';
    }
}
