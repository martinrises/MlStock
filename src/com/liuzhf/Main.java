package com.liuzhf;

import com.liuzhf.data.DataFactory;
import com.liuzhf.data.DataReader;
import com.liuzhf.data.entity.RawDataItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        获取svm训练需要的数据
          */
        DataFactory.getDataForSVM();

        /*
        将数据传入svm训练机，得到合适的参数
         */
    }
}
