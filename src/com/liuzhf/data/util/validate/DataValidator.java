package com.liuzhf.data.util.validate;

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

}
