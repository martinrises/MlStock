package com.liuzhf;

import com.liuzhf.data.DataFactory;
import com.liuzhf.data.entity.DataForSVM;
import com.liuzhf.svm.SvmTrainer;
import com.liuzhf.svm.entity.SvmTrainResult;
import libsvm.svm_model;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        /*
        获取svm训练需要的数据
          */
        List<DataForSVM> dataForSvmList = DataFactory.getDataForSVM();

        /*
        将数据传入svm训练机，得到合适的参数
         */
        SvmTrainResult result = SvmTrainer.trainSvm(dataForSvmList);
    }
}
