package com.liuzhf.data.util.validate;

import com.liuzhf.data.DataFactory;
import com.liuzhf.data.entity.DataFeatured;
import com.liuzhf.data.entity.DataPerDay;
import com.liuzhf.data.entity.RawDataItem;
import com.liuzhf.data.util.check.IsUpChecker;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public static void validateDataFeatured(List<DataFeatured> dataFeaturedList) {
        for (Iterator<DataFeatured> iterator = dataFeaturedList.iterator(); iterator.hasNext(); ) {
            DataFeatured data = iterator.next();
            if(data.getmDate().equals("2015-10-19")) {
                /*
                DataFeatured{mDate='2015-10-19',
                mCurrentPrice=3386.6997, mAvgPrice5m=3383.4146, mAvgPrice15m=3385.5686,
                mAvgPrice30m=3382.4443, mAvgPrice60m=3375.1318, mAvgPrice2h=3381.571,
                mAvgPrice1d=3393.9512,
                 mAvgPrice2d=3389.026, mAvgPrice4d=3344.6416,
                 mAvgPrice8d=3285.7456, mAvgPrice16d=3198.214, mAvgPrice32d=3165.5032,
                 mAvgPrice64d=3477.8381, mAvgPrice128d=3964.3596, mAvgPrice256d=3483.2947,
                 mAvgPrice512d=2802.6475,

                 mCurrentVolume=3.78112183E10,
                 mAvgVolume2d=3.86786379E10, mAvgVolume4d=3.46233587E10, mAvgVolume8d=3.17188711375E10,
                 mAvgVolume16d=2.627662571875E10, mAvgVolume32d=3.002374581875E10,
                 mAvgVolume64d=3.84786480609375E10, mAvgVolume128d=4.89866067078125E10,
                 mAvgVolume256d=4.20072195296875E10, mAvgVolume512d=2.684338668203125E10,
                 mIsUp=true}
                 */
                if(data.getmCurrentPrice() != 3386.6997f ||
                        data.getmAvgPrice5m() != 3383.4146f ||
                        data.getmAvgPrice15m() != 3385.5686f ||
                        data.getmAvgPrice30m() != 3382.4443f ||
                        data.getmAvgPrice60m() != 3375.1318f ||
                        data.getmAvgPrice2h() != 3381.571f ||
                        data.getmAvgPrice1d() != 3393.9512f ||
                        data.getmAvgPrice2d() != 3389.026f ||
                        data.getmAvgPrice4d() != 3344.6416f ||
                        data.getmAvgPrice8d() != 3285.7456f ||
                        data.getmAvgPrice16d() != 3198.214f ||
                        data.getmAvgPrice32d() != 3165.5032f ||
                        data.getmAvgPrice64d() != 3477.8381f ||
                        data.getmAvgPrice128d() != 3964.3596f ||
                        data.getmAvgPrice256d() != 3483.2947f ||
                        data.getmAvgPrice512d() != 2802.6475f ||
                        data.getmCurrentVolume() != 3.78112183E10d ||
                        data.getmAvgVolume2d() != 3.86786379E10d ||
                        data.getmAvgVolume4d() != 3.46233587E10d ||
                        data.getmAvgVolume8d() != 3.17188711375E10d ||
                        data.getmAvgVolume16d() != 2.627662571875E10d ||
                        data.getmAvgVolume32d() != 3.002374581875E10d ||
                        data.getmAvgVolume64d() != 3.84786480609375E10d ||
                        data.getmAvgVolume128d() != 4.89866067078125E10d ||
                        data.getmAvgVolume256d() != 4.20072195296875E10d ||
                        data.getmAvgVolume512d() != 2.684338668203125E10d){
                    throw new IllegalStateException("something wrong with getting DataFeatured");
                }

                break;
            }
        }
    }

    public static void validateIsUp(List<DataPerDay> dataPerDay) {
        IsUpChecker isUpChecker = new IsUpChecker(dataPerDay);
        int size = dataPerDay.size();
        for (int i = 0; i != size; i++) {
            DataPerDay data = dataPerDay.get(i);
            if(data.getDate().equals("2013-11-15")) {
                Map<String, Float> priceRange = isUpChecker.getPriceRange(i, 5);
                if(2153.213f != priceRange.get(IsUpChecker.KEY_HIGH_PX) ||
                        2078.989f != priceRange.get(IsUpChecker.KEY_LOW_PX) ||
                        60.551025f != isUpChecker.getPriceDiff(i, 5)) {
                    throw new IllegalStateException("something wrong with checking isUp");
                }
                break;
            }
        }
    }
}
