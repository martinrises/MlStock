package com.liuzhf.data.entity;

/**
 * Created by asus on 2016/11/19.
 */
public class RawDataItem {

    // 2005-01-04 09:35:00,1260.782,1238.187,38706300.0,1260.782,1238.187,183419900.0
    private String mDate;
    private String mTime;

    // HighPx,LowPx,TotalVolumeTraded,OpeningPx,mClosingPx,TotalTurnover
    private float mHighPx, mLowPx, mOpeningPx, mClosingPx;
    private double mTotalVolumeTraded, mTotalTurnover;

    public RawDataItem(String mDate, String mTime, float mHighPx, float mLowPx, float mOpeningPx, float closingPx, double mTotalVolumeTraded, double mTotalTurnover) {
        this.mDate = mDate;
        this.mTime = mTime;
        this.mHighPx = mHighPx;
        this.mLowPx = mLowPx;
        this.mOpeningPx = mOpeningPx;
        mClosingPx = closingPx;
        this.mTotalVolumeTraded = mTotalVolumeTraded;
        this.mTotalTurnover = mTotalTurnover;
    }

    public RawDataItem(String... strs) {
        this.mDate = strs[0];
        this.mTime = strs[1];
        this.mHighPx = Float.valueOf(strs[2]);
        this.mLowPx = Float.valueOf(strs[3]);
        this.mOpeningPx = Float.valueOf(strs[4]);
        this.mClosingPx = Float.valueOf(strs[5]);
        this.mTotalVolumeTraded = Double.valueOf(strs[6]);
        this.mTotalTurnover = Double.valueOf(strs[7]);
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public float getmHighPx() {
        return mHighPx;
    }

    public void setmHighPx(float mHighPx) {
        this.mHighPx = mHighPx;
    }

    public float getmLowPx() {
        return mLowPx;
    }

    public void setmLowPx(float mLowPx) {
        this.mLowPx = mLowPx;
    }

    public float getmOpeningPx() {
        return mOpeningPx;
    }

    public void setmOpeningPx(float mOpeningPx) {
        this.mOpeningPx = mOpeningPx;
    }

    public float getmClosingPx() {
        return mClosingPx;
    }

    public void setmClosingPx(float mClosingPx) {
        this.mClosingPx = mClosingPx;
    }

    public double getmTotalVolumeTraded() {
        return mTotalVolumeTraded;
    }

    public void setmTotalVolumeTraded(long mTotalVolumeTraded) {
        this.mTotalVolumeTraded = mTotalVolumeTraded;
    }

    public double getmTotalTurnover() {
        return mTotalTurnover;
    }

    public void setmTotalTurnover(long mTotalTurnover) {
        this.mTotalTurnover = mTotalTurnover;
    }

    @Override
    public String toString() {
        return "RawDataItem{" +
                "mDate='" + getmDate() + '\'' +
                ", mTime='" + getmTime() + '\'' +
                ", mHighPx=" + getmHighPx() +
                ", mLowPx=" + getmLowPx() +
                ", mOpeningPx=" + getmOpeningPx() +
                ", mClosingPx=" + getmClosingPx() +
                ", mTotalVolumeTraded=" + getmTotalVolumeTraded() +
                ", mTotalTurnover=" + getmTotalTurnover() +
                '}';
    }
}
