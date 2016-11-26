package com.liuzhf.data;

import com.liuzhf.data.entity.DataForSVM;
import com.liuzhf.data.entity.DataPerDay;
import com.liuzhf.data.entity.DataFeatured;
import com.liuzhf.data.entity.RawDataItem;
import com.liuzhf.data.util.avg.AvgComputorClosePriceForDay;
import com.liuzhf.data.util.avg.AvgComputorClosePriceForMin;
import com.liuzhf.data.util.check.IsUpChecker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by asus on 2016/11/19.
 */
public class DataFactory {

    public static List<DataForSVM> getDataForSVM() {

        List<RawDataItem> rawDataItems = DataReader.readData("src/price.csv");

        List<DataPerDay> dataPerDay = getDataPerDay(rawDataItems);

        List<DataFeatured> dataFeaturedList = getPriceForSVM(dataPerDay);

        ArrayList<DataForSVM> dataForSvmList = dataFeaturedList.stream().map(dataFeatured -> new DataForSVM(dataFeatured.getmDate(),
                dataFeatured.ismIsUp(), // isup after 5days
                1f, // current dataFeatured
                dataFeatured.getmAvgPrice5m() / dataFeatured.getmCurrentPrice(), // 5m
                dataFeatured.getmAvgPrice15m() / dataFeatured.getmCurrentPrice(), // 15m
                dataFeatured.getmAvgPrice30m() / dataFeatured.getmCurrentPrice(), // 30m
                dataFeatured.getmAvgPrice60m() / dataFeatured.getmCurrentPrice(), // 60m
                dataFeatured.getmAvgPrice2h() / dataFeatured.getmCurrentPrice(), // 2h
                dataFeatured.getmAvgPrice1d() / dataFeatured.getmCurrentPrice(), // 4h
                dataFeatured.getmAvgPrice2d() / dataFeatured.getmCurrentPrice(), // 2d
                dataFeatured.getmAvgPrice4d() / dataFeatured.getmCurrentPrice(), // 4d
                dataFeatured.getmAvgPrice8d() / dataFeatured.getmCurrentPrice(), // 8d
                dataFeatured.getmAvgPrice16d() / dataFeatured.getmCurrentPrice(), // 16d
                dataFeatured.getmAvgPrice32d() / dataFeatured.getmCurrentPrice(), // 32d
                dataFeatured.getmAvgPrice64d() / dataFeatured.getmCurrentPrice(), // 64d
                dataFeatured.getmAvgPrice128d() / dataFeatured.getmCurrentPrice(), // 128d
                dataFeatured.getmAvgPrice256d() / dataFeatured.getmCurrentPrice(), // 256d
                dataFeatured.getmAvgPrice512d() / dataFeatured.getmCurrentPrice() // 512d
        )).collect(Collectors.toCollection(ArrayList::new));

        return dataForSvmList;
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

    private static List<DataFeatured> getPriceForSVM(List<DataPerDay> dataPerDays) {
        List<DataFeatured> result = new ArrayList<>();

        AvgComputorClosePriceForDay avgComputorClosePriceForDay = new AvgComputorClosePriceForDay(dataPerDays);
        IsUpChecker isUpChecker = new IsUpChecker(dataPerDays);
        for(int i = dataPerDays.size()-1; i >= 0; i--) {
            DataPerDay dataPerDay = dataPerDays.get(i);
            List<RawDataItem> rawItems = dataPerDay.getRawItems();
            AvgComputorClosePriceForMin avgClosePriceForMin = new AvgComputorClosePriceForMin(rawItems);
            result.add(new DataFeatured(dataPerDay.getDate(), dataPerDay.getClosePrice(), // 当日收盘价
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
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 64), // 64d avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 128), // 128d avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 256), // 256d avg
                    avgComputorClosePriceForDay.getAvgFromEnd(i, 512), // 512d avg
                    isUpChecker.isUp(i, 5)// is up after 5 days;
                            ));
        }

        return result;
    }
}
