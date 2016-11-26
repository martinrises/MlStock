package com.liuzhf.data.entity;

import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class DataPerDay {
    private List<RawDataItem> mItems;
    private String mDate;

    public DataPerDay(String date, List<RawDataItem> items) {
        this.mDate = date;
        this.mItems = items;
    }

    public String getDate() {
        return this.mDate;
    }

    public List<RawDataItem> getRawItems() {
        return this.mItems;
    }

    public float getClosePrice() {
        return mItems.get(mItems.size() - 1).getmClosingPx();
    }

    public float getOpenPrice() {
        return mItems.get(0).getmOpeningPx();
    }

    public float getHighPrice() {
        float highPrice = Float.MIN_VALUE;
        for(int i = 0; i != mItems.size(); i++) {
            float price = mItems.get(i).getmHighPx();
            if(highPrice < price){
                highPrice = price;
            }
        }
        return highPrice;
    }

    public float getLowPrice() {
        float lowPrice = Float.MAX_VALUE;
        for(int i = 0; i != mItems.size(); i++) {
            float price = mItems.get(i).getmLowPx();
            if(lowPrice > price){
                lowPrice = price;
            }
        }
        return lowPrice;
    }

    @Override
    public String toString() {
        return getOpenPrice() + "; " + getClosePrice() + "; " + getHighPrice() + "; " + getLowPrice();
    }
}
