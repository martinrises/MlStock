package com.liuzhf;

import com.liuzhf.data.DataFactory;
import com.liuzhf.data.DataWriter;
import com.liuzhf.data.entity.DataForSVM;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        /*
        获取svm训练需要的数据
          */
        List<DataForSVM> dataForSvmList = DataFactory.getDataForSVM();
        List<DataForSVM> dataForTraining = new ArrayList<>();
        List<DataForSVM> dataForTest = new ArrayList<>();
        int size = dataForSvmList.size();
        int i = size * 3 / 10;
        dataForTest.addAll(dataForSvmList.subList(0, i));
        dataForTraining.addAll(dataForSvmList.subList(i + 1, size));

        // scale
//        FeatureScaleResult trainDataScaled = SvmTrainer.scaleData(dataForTraining);
//        FeatureScaleResult testDataScaled = SvmTrainer.scaleData(dataForTest, trainDataScaled.getmFeatureScale());
//        List<DataForSVM> trainDataForOutput = trainDataScaled.getmDataScaled();
//        List<DataForSVM> testDataForOutput = testDataScaled.getmDataScaled();
        List<DataForSVM> trainDataForOutput = dataForTraining;
        List<DataForSVM> testDataForOutput = dataForTest;

        // output files
        DataWriter.checkAndWriteFile("train", trainDataForOutput);
        DataWriter.checkAndWriteFile("test", testDataForOutput);
        DataWriter.checkAndWriteFileWithDate("test_date", testDataForOutput);
    }
}
