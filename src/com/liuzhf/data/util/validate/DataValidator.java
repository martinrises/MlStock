package com.liuzhf.data.util.validate;

import com.liuzhf.data.DataFactory;
import com.liuzhf.data.entity.DataPerDay;
import com.liuzhf.data.entity.RawDataItem;

import java.util.Iterator;
import java.util.List;

/**
 * Created by asus on 2016/11/28.
 */
public class DataValidator {

    public static void validateRawDataItems(List<RawDataItem> rawDataItems) {
        for (Iterator<RawDataItem> iterator = rawDataItems.iterator(); iterator.hasNext(); ) {
            RawDataItem rawDataItem = iterator.next();
            if(rawDataItem.getmDate().equals("2016-07-11") && rawDataItem.getmTime().equals("09:35:00")) {

                if(rawDataItem.getmHighPx() != 2998.292f
                        || rawDataItem.getmLowPx() != 2993.7488f
                        || rawDataItem.getmOpeningPx() != 2993.7488f
                        || rawDataItem.getmClosingPx() != 2997.741f
                        || rawDataItem.getmTotalVolumeTraded() != 1.0577446E9d) {
                    throw new IllegalStateException("Something is wrong with getting RawDataItems");
                }
                break;
            }
        }
    }

    public static void validateRawDataItemsFilted(List<RawDataItem> rawDataItems) {

        for (Iterator<RawDataItem> iterator = rawDataItems.iterator(); iterator.hasNext(); ) {
            RawDataItem rawDataItem = iterator.next();
            if(rawDataItem.getmDate().equals("2015-07-01") && rawDataItem.getmTime().equals("09:35:00")) {

                if(rawDataItem.getmHighPx() <= DataFactory.PRICE_THRESHOLD
                        || rawDataItem.getmLowPx() <= DataFactory.PRICE_THRESHOLD
                        || rawDataItem.getmOpeningPx() <= DataFactory.PRICE_THRESHOLD
                        || rawDataItem.getmClosingPx() <= DataFactory.PRICE_THRESHOLD
                        || rawDataItem.getmTotalVolumeTraded() <= DataFactory.PRICE_THRESHOLD) {
                    throw new IllegalStateException("Something is wrong with filtering RawDataItems");
                }
                break;
            }
        }
    }

    public static void validateDataPerDay(List<DataPerDay> dataPerDay) {
        for (Iterator<DataPerDay> iterator = dataPerDay.iterator(); iterator.hasNext(); ) {
            DataPerDay data = iterator.next();
            if(data.getDate().equals("2016-01-22")) {

                if(data.getOpenPrice() != 2911.1116f ||
                        data.getClosePrice() != 2916.5615f ||
                        data.getHighPrice() != 2931.3586f ||
                        data.getLowPrice() != 2851.7327f ||
                        data.getTotalVolumeTraded() != 1.59810734E10d) {
                    throw new IllegalStateException("Something is wrong with getting DataPerDays");
                }
                break;
            }
        }
    }
}
