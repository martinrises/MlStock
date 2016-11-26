package com.liuzhf;

import com.liuzhf.data.DataFactory;
import com.liuzhf.data.entity.DataForSVM;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
        int i = size * 7 / 10;
        dataForTraining.addAll(dataForSvmList.subList(0, i));
        dataForTest.addAll(dataForSvmList.subList(i + 1, size));

        // scale
//        FeatureScaleResult trainDataScaled = SvmTrainer.scaleData(dataForTraining);
//        FeatureScaleResult testDataScaled = SvmTrainer.scaleData(dataForTest, trainDataScaled.getmFeatureScale());
//        List<DataForSVM> trainDataForOutput = trainDataScaled.getmDataScaled();
//        List<DataForSVM> testDataForOutput = testDataScaled.getmDataScaled();
        List<DataForSVM> trainDataForOutput = dataForTraining;
        List<DataForSVM> testDataForOutput = dataForTest;

        // output files
        checkAndWriteFile("train", trainDataForOutput);
        checkAndWriteFile("test", testDataForOutput);
    }

    private static void checkAndWriteFile(String filename, List<DataForSVM> dataList) {
        File f = new File("./" + filename);
        if(!f.exists()) {
            try {
                f.createNewFile();

                PrintWriter writer = new PrintWriter(filename, "UTF-8");
                for(DataForSVM data : dataList) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(data.isUp() ? "1" : "-1").append(" ");
                    float[] features = data.getFeatures();
                    for(int i = 0; i != features.length; i++) {
                        sb.append((i + 1)).append(":").append(features[i]).append(" ");
                    }
                    writer.println(sb.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
