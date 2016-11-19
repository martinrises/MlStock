package com.liuzhf;

import com.liuzhf.data.DataReader;
import com.liuzhf.data.entity.RawDataItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        获取svm训练需要的数据
          */
        List<RawDataItem> rawDataItems = DataReader.readData("src/price.csv");
        System.out.print(rawDataItems);

        /*
        将数据传入svm训练机，得到合适的参数
         */
    }
}
