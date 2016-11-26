package com.liuzhf;

import com.liuzhf.data.DataFactory;
import com.liuzhf.data.entity.DataForSVM;
import com.liuzhf.svm.SvmTrainer;
import com.liuzhf.svm.entity.FeatureScale;
import com.liuzhf.svm.entity.FeatureScaleResult;
import com.liuzhf.svm.entity.SvmTrainResult;
import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_problem;

import java.util.ArrayList;
import java.util.Collections;
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

        /*
        将数据传入svm训练机，得到合适的参数
         */
        SvmTrainResult result = SvmTrainer.trainSvm(dataForTraining);

        /*
        预测
         */
        FeatureScale featureScale = result.getmScale();
        FeatureScaleResult featureScaleResult = SvmTrainer.scaleData(dataForTest, featureScale);
        svm_problem svm_problem = SvmTrainer.constructSvmProblem(featureScaleResult.getmDataScaled());
        int cntRight = 0;
        int cntPre = 0, cntPreDivided;
        int cntRecall, cntRecallDevided;
        double[] y = svm_problem.y;
        svm_node[][] x = svm_problem.x;
        int l = svm_problem.l;
        svm_model svm_model = result.getmModle();
        for(int mn = 0 ; mn != l; mn++) {
            double v = svm.svm_predict(svm_model, x[mn]);
            System.out.print(dataForTest.get(mn).getDate() + "，v : " + v +"\n");

        }

//        System.out.print("The result is : " + cntRight * 100 / l + "%");
    }
}
