package com.liuzhf.data;

import com.liuzhf.data.entity.DataForSVM;
import com.liuzhf.data.entity.DataPerDay;
import com.liuzhf.data.entity.PriceForSVM;
import com.liuzhf.data.entity.RawDataItem;
import com.liuzhf.data.util.AvgComputorClosePriceForDay;
import com.liuzhf.data.util.AvgComputorClosePriceForMin;

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

    private static List<PriceForSVM> getPriceForSVM(List<DataPerDay> dataPerDays) {
        List<PriceForSVM> result = new ArrayList<>();

        AvgComputorClosePriceForDay avgComputorClosePriceForDay = new AvgComputorClosePriceForDay(dataPerDays);
        for(int i = dataPerDays.size()-1; i >= 0; i++) {
            DataPerDay dataPerDay = dataPerDays.get(i);
            List<RawDataItem> rawItems = dataPerDay.getRawItems();
            AvgComputorClosePriceForMin avgClosePriceForMin = new AvgComputorClosePriceForMin(rawItems);
            result.add(new PriceForSVM(dataPerDay.getClosePrice(), // 当日收盘价
                    avgClosePriceForMin.getAvgFromEnd(rawItems.size() - 2, 1), // 5min前收盘价
                    avgClosePriceForMin.getAvgFromEnd(rawItems.size() - 1, 3), // 15min均价
                    avgClosePriceForMin.getAvgFromEnd(rawItems.size() - 1, 6), // 30min avg
                    avgClosePriceForMin.getAvgFromEnd(rawItems.size() - 1, 12), // 60min avg
                    avgClosePriceForMin.getAvgFromEnd(rawItems.size() - 1, 24), // 2h avg
                    avgClosePriceForMin.getAvgFromEnd(rawItems.size() - 1, 48), // 4h avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 2), // 2d avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 4), // 4d avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 8), // 8d avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 16), // 16d avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 32), // 32d avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 64), // 64 avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 128), // 128 avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 256), // 256 avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 512) // 512 avg
                            ));
        }

        return result;
    }
}