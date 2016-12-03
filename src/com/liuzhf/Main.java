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
        dataForTraining.addAll(dataForSvmList.subList(i + 1, size));
        dataForTest.addAll(dataForSvmList.subList(0, i));

        float percent = 1f;
        int trainingSize = dataForTraining.size();
        dataForTraining = dataForTraining.subList((int) (trainingSize * (1-percent)), trainingSize);

        // output files
        DataWriter.checkAndWriteFile("train", dataForTraining);
        DataWriter.checkAndWriteFile("test", dataForTest);
        DataWriter.checkAndWriteFileWithDate("test_date", dataForTest);
    }
}
