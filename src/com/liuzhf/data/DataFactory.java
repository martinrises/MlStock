package com.liuzhf.data;

import com.liuzhf.data.entity.*;
import com.liuzhf.data.util.avg.AvgComputorClosePriceForDay;
import com.liuzhf.data.util.avg.AvgComputorClosePriceForMin;
import com.liuzhf.data.util.avg.AvgComputorVolumeForDay;
import com.liuzhf.data.util.check.IsUpChecker;
import com.liuzhf.data.util.validate.DataValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by asus on 2016/11/19.
 */
public class DataFactory {

    public static List<DataForRNN> getDataForRNN() {
        List<RawDataItem> rawDataItems = DataReader.readData("src/price.csv");
        DataValidator.validateRawDataItems(rawDataItems);

        List<RawDataItem> rawDataItemsFiltered = filterRawData(rawDataItems); // filter wrong data
        DataValidator.validateRawDataItemsFilted(rawDataItemsFiltered);

        List<DataPerDay> dataPerDays = getDataPerDay(rawDataItemsFiltered);
        DataValidator.validateDataPerDay(dataPerDays);

        IsUpChecker isUpChecker = new IsUpChecker(dataPerDays);
        List<DataForRNN> dataForRNNs = new ArrayList<>();
        int size = dataPerDays.size();
        for(int i = 0; i != size; i++) {
            DataPerDay data = dataPerDays.get(i);
            dataForRNNs.add(new DataForRNN(data, isUpChecker.isUp(i, 5) ? 1 : 0));
        }

        return dataForRNNs;
    }

    public static List<DataPerDay> getDataForRNN2() {

        List<RawDataItem> rawDataItems = DataReader.readData("src/price.csv");
        DataValidator.validateRawDataItems(rawDataItems);

        List<RawDataItem> rawDataItemsFiltered = filterRawData(rawDataItems); // filter wrong data
        DataValidator.validateRawDataItemsFilted(rawDataItemsFiltered);

        List<DataItemForRNN> dataItems = getDataItemsForRNN(rawDataItemsFiltered);

        List<DataPerDay> datas = getDataPerDay(dataItems);

        return datas;
    }

    private static List<DataItemForRNN> getDataItemsForRNN(List<RawDataItem> rawDataItems) {
        AvgComputorClosePriceForMin avgComputor = new AvgComputorClosePriceForMin(rawDataItems);

        List<DataItemForRNN> dataItems = new ArrayList<>();

        int size = rawDataItems.size();
        for(int i = 0; i != size; i++) {
            RawDataItem rawDataItem = rawDataItems.get(i);
            dataItems.add(new DataItemForRNN(rawDataItem.getmDate(),
                    rawDataItem.getmTime(),
                    rawDataItem.getmHighPx(),
                    rawDataItem.getmLowPx(),
                    rawDataItem.getmOpeningPx(),
                    rawDataItem.getmClosingPx(),
                    rawDataItem.getmTotalVolumeTraded(),
                    rawDataItem.getmTotalTurnover(),
                    avgComputor.getAvgFromEnd(i, 3),  // 15min
                    avgComputor.getAvgFromEnd(i, 6),  // 30min
                    avgComputor.getAvgFromEnd(i, 12), // 1h
                    avgComputor.getAvgFromEnd(i, 24), // 2h
                    avgComputor.getAvgFromEnd(i, 48), // 1d
                    avgComputor.getAvgFromEnd(i, 96), // 2d
                    avgComputor.getAvgFromEnd(i, 192), // 4d
                    avgComputor.getAvgFromEnd(i, 384), // 8d
                    avgComputor.getAvgFromEnd(i, 768), // 16d
                    avgComputor.getAvgFromEnd(i, 1536), // 32d
                    avgComputor.getAvgFromEnd(i, 3072), // 64d
                    avgComputor.getAvgFromEnd(i, 6144), // 128d
                    avgComputor.getAvgFromEnd(i, 12288) // 256d
            ));
        }
        return dataItems;
    }

    public static List<DataForSVM> getDataForSVM() {

        List<RawDataItem> rawDataItems = DataReader.readData("src/price.csv");
        DataValidator.validateRawDataItems(rawDataItems);

        List<RawDataItem> rawDataItemsFiltered = filterRawData(rawDataItems); // filter wrong data
        DataValidator.validateRawDataItemsFilted(rawDataItemsFiltered);

        List<DataPerDay> dataPerDay = getDataPerDay(rawDataItemsFiltered);
        DataValidator.validateDataPerDay(dataPerDay);

        List<DataFeatured> dataFeaturedList = getFeaturedData(dataPerDay);
        DataValidator.validateDataFeatured(dataFeaturedList);
        DataValidator.validateIsUp(dataPerDay);

        List<DataFeatured> dataFeaturedListFiltered = filterFeatureData(dataFeaturedList);

        ArrayList<DataForSVM> dataForSvmList = dataFeaturedListFiltered.stream().map(dataFeatured -> new DataForSVM(dataFeatured.getmDate(),
                dataFeatured.ismIsUp(), // isup after 5days
                1d, // current dataFeatured
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
                dataFeatured.getmAvgPrice512d() / dataFeatured.getmCurrentPrice(), // 512d

                1d, // current volume
                dataFeatured.getmAvgVolume2d() / dataFeatured.getmCurrentVolume(), // 2d
                dataFeatured.getmAvgVolume4d() / dataFeatured.getmCurrentVolume(), // 4d
                dataFeatured.getmAvgVolume8d() / dataFeatured.getmCurrentVolume(), // 8d
                dataFeatured.getmAvgVolume16d() / dataFeatured.getmCurrentVolume(), // 16d
                dataFeatured.getmAvgVolume32d() / dataFeatured.getmCurrentVolume(), // 32d
                dataFeatured.getmAvgVolume64d() / dataFeatured.getmCurrentVolume(), // 64d
                dataFeatured.getmAvgVolume128d() / dataFeatured.getmCurrentVolume(), // 128d
                dataFeatured.getmAvgVolume256d() / dataFeatured.getmCurrentVolume(), // 256d
                dataFeatured.getmAvgVolume512d() / dataFeatured.getmCurrentVolume() // 512d
        )).collect(Collectors.toCollection(ArrayList::new));

        return dataForSvmList;
    }
    
    private static List<DataFeatured> filterFeatureData(List<DataFeatured> dataFeaturedList) {
        List<DataFeatured> dataFeaturedFiltered = dataFeaturedList.stream()
                .filter(data -> data.getmAvgPrice5m() != 0
                        && data.getmAvgPrice15m() != 0
                        && data.getmAvgPrice15m() != 0
                        && data.getmAvgPrice30m() != 0
                        && data.getmAvgPrice60m() != 0
                        && data.getmAvgPrice2h() != 0
                        && data.getmAvgPrice1d() != 0
                        && data.getmAvgPrice2d() != 0
                        && data.getmAvgPrice4d() != 0
                        && data.getmAvgPrice8d() != 0
                        && data.getmAvgPrice16d() != 0
                        && data.getmAvgPrice32d() != 0
                        && data.getmAvgPrice64d() != 0
                        && data.getmAvgPrice128d() != 0
                        && data.getmAvgPrice256d() != 0
                        && data.getmAvgPrice512d() != 0
                ).collect(Collectors.toList());
        return dataFeaturedFiltered;
    }

    // 有一些数据明显错误，将这些数据移除
    public static final float PRICE_THRESHOLD = 800f;
    private static List<RawDataItem> filterRawData(List<RawDataItem> dataList) {

        List<RawDataItem> dataListFiltered = dataList.stream()
                .filter(data -> data.getmLowPx() > PRICE_THRESHOLD && data.getmHighPx() > PRICE_THRESHOLD && data.getmOpeningPx() > PRICE_THRESHOLD && data.getmClosingPx() > PRICE_THRESHOLD)
                .collect(Collectors.toList());
        return dataListFiltered;
    }

    private static List<DataPerDay> getDataPerDay(List<? extends RawDataItem> rawDataItems) {
        List<DataPerDay> result = new ArrayList<>();

        String date = "";
        ArrayList<RawDataItem> items = null;
        Iterator<? extends RawDataItem> it = rawDataItems.iterator();
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

    private static List<DataFeatured> getFeaturedData(List<DataPerDay> dataPerDays) {
        List<DataFeatured> result = new ArrayList<>();

        AvgComputorClosePriceForDay avgComputorClosePriceForDay = new AvgComputorClosePriceForDay(dataPerDays);
        AvgComputorVolumeForDay avgComputorVolumeForDay = new AvgComputorVolumeForDay(dataPerDays);
        IsUpChecker isUpChecker = new IsUpChecker(dataPerDays);
        for(int i = dataPerDays.size()-1; i >= 0; i--) {
            DataPerDay dataPerDay = dataPerDays.get(i);
            List<? extends RawDataItem> rawItems = dataPerDay.getRawItems();
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

                    dataPerDay.getTotalVolumeTraded(), // 当日的成交量
                    avgComputorVolumeForDay.getAvgFromEnd(i, 2), // 2d avg
                    avgComputorVolumeForDay.getAvgFromEnd(i, 4), // 4d avg
                    avgComputorVolumeForDay.getAvgFromEnd(i, 8), // 8d avg
                    avgComputorVolumeForDay.getAvgFromEnd(i, 16), // 16d avg
                    avgComputorVolumeForDay.getAvgFromEnd(i, 32), // 32d avg
                    avgComputorVolumeForDay.getAvgFromEnd(i, 64), // 64d avg
                    avgComputorVolumeForDay.getAvgFromEnd(i, 128), // 128d avg
                    avgComputorVolumeForDay.getAvgFromEnd(i, 256), // 256d avg
                    avgComputorVolumeForDay.getAvgFromEnd(i, 512), // 512d avg

                    isUpChecker.isUp(i, 5)// is up after 5 days;
                            ));
        }

        return result;
    }
}
