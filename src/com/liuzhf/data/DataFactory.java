package com.liuzhf.data;

import com.liuzhf.data.entity.DataForSVM;
import com.liuzhf.data.entity.DataPerDay;
import com.liuzhf.data.entity.PriceForSVM;
import com.liuzhf.data.entity.RawDataItem;
import com.sun.javaws.security.AppContextUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by asus on 2016/11/19.
 */
public class DataFactory {

    public static List<DataForSVM> getDataForSVM() {

        List<RawDataItem> rawDataItems = DataReader.readData("src/price.csv");

        List<DataPerDay> dataPerDay = getDataPerDay(rawDataItems);

        List<PriceForSVM> pricesForSVM = getPriceForSVM(dataPerDay);
        return null;
    }

    private static List<DataPerDay> getDataPerDay(List<RawDataItem> rawDataItems) {
        List<DataPerDay> result = new ArrayList<>();

        String date = "";
        ArrayList<RawDataItem> items = null;
        Iterator<RawDataItem> it = rawDataItems.iterator();
        while(it.hasNext()) {

            RawDataItem rawDataItem = it.next();
            if(!date.equals(rawDataItem.getmDate())) {
                if(items != null) {
                    result.add(new DataPerDay(date, items));
                }
                date = rawDataItem.getmDate();
                items = new ArrayList<>();
            }

            items.add(rawDataItem);
        }

        result.add(new DataPerDay(date, items));
        return result;
    }

    private static List<PriceForSVM> getPriceForSVM(List<DataPerDay> rawDataItems) {
        List<PriceForSVM> result = new ArrayList<>();

// float mCurrentPrice, float mAvgPrice5m, float mAvgPrice15m, float mAvgPrice30m, float mAvgPrice60m, float mAvgPrice2h, float mAvgPrice1d, float mAvgPrice2d, float mAvgPrice4d, float mAvgPrice8d, float mAvgPrice16d, float mAvgPrice32d, float mAvgPrice64d, float mAvgPrice128d, float mAvgPrice256d, float mAvgPrice512d) {

//        for(int i = rawDataItems.size()-1; i >= 0; i++) {
//            result.add(new PriceForSVM(1f, ));
//        }

        return null;
    }
}
