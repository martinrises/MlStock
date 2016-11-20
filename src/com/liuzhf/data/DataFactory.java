package com.liuzhf.data;

import com.liuzhf.data.entity.DataForSVM;
import com.liuzhf.data.entity.DataPerDay;
import com.liuzhf.data.entity.PriceForSVM;
import com.liuzhf.data.entity.RawDataItem;
import com.liuzhf.data.util.avg.AvgComputorClosePriceForDay;
import com.liuzhf.data.util.avg.AvgComputorClosePriceForMin;
import com.liuzhf.data.util.check.IsUpChecker;

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

        ArrayList<DataForSVM> dataForSVMs = new ArrayList<>();
        for(PriceForSVM price : pricesForSVM) {
            dataForSVMs.add(new DataForSVM(price.getmDate(),
                    price.ismIsUp(), // isup after 5days
                    1f, // current price
                    price.getmAvgPrice5m()/price.getmCurrentPrice(), // 5m
                    price.getmAvgPrice15m()/price.getmCurrentPrice(), // 15m
                    price.getmAvgPrice30m()/price.getmCurrentPrice(), // 30m
                    price.getmAvgPrice60m()/price.getmCurrentPrice(), // 60m
                    price.getmAvgPrice2h()/price.getmCurrentPrice(), // 2h
                    price.getmAvgPrice1d()/price.getmCurrentPrice(), // 4h
                    price.getmAvgPrice2d()/price.getmCurrentPrice(), // 2d
                    price.getmAvgPrice4d()/price.getmCurrentPrice(), // 4d
                    price.getmAvgPrice8d()/price.getmCurrentPrice(), // 8d
                    price.getmAvgPrice16d()/price.getmCurrentPrice(), // 16d
                    price.getmAvgPrice32d()/price.getmCurrentPrice(), // 32d
                    price.getmAvgPrice64d()/price.getmCurrentPrice(), // 64d
                    price.getmAvgPrice128d()/price.getmCurrentPrice(), // 128d
                    price.getmAvgPrice256d()/price.getmCurrentPrice(), // 256d
                    price.getmAvgPrice512d()/price.getmCurrentPrice() // 512d
                    ));
        }

        return dataForSVMs;
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
        IsUpChecker isUpChecker = new IsUpChecker(dataPerDays);
        for(int i = dataPerDays.size()-1; i >= 0; i--) {
            DataPerDay dataPerDay = dataPerDays.get(i);
            List<RawDataItem> rawItems = dataPerDay.getRawItems();
            AvgComputorClosePriceForMin avgClosePriceForMin = new AvgComputorClosePriceForMin(rawItems);
            result.add(new PriceForSVM(dataPerDay.getDate(), dataPerDay.getClosePrice(), // 当日收盘价
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
