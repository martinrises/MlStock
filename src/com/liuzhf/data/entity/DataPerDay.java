package com.liuzhf.data.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by asus on 2016/11/20.
 */
public class DataPerDay {
    private List<RawDataItem> mItem;
    private String mDate;

    public DataPerDay(String date, List<RawDataItem> items) {
        this.mDate = date;
        this.mItem = items;
    }
}
