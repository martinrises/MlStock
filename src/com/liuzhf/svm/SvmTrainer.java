package com.liuzhf.svm;

import com.liuzhf.data.entity.DataForSVM;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_problem;

import java.util.List;

/**
 * Created by asus on 2016/11/26.
 */
public class SvmTrainer {

    public static svm_model trainSvm(List<DataForSVM> dataList) {

        // organize data for svm
        svm_problem sp = constructSvmProblem(dataList);

        // scale data

        // traverse data to find the most suitable kernel function
        //// traverse data to find the best parameter
        ////// check data

        return null;
    }

    private static svm_problem constructSvmProblem(List<DataForSVM> dataList) {
        svm_problem sp = new svm_problem();
        sp.l = dataList.size();
        double[] spY = new double[sp.l];
        svm_node[][] spX = new svm_node[sp.l][];
        for(int i = 0; i != sp.l; i++) {
            DataForSVM data = dataList.get(i);
            spY[i] = data.isUp() ? 1f: 0f;

            svm_node[] nodes = new svm_node[data.getFeatures().length];
            for(int j = 0; j != nodes.length; j++) {
                svm_node node = new svm_node();
                node.index = j;
                node.value = data.getFeatures()[j];
                nodes[j] = node;
            }
            spX[i] = nodes;
        }
        sp.y = spY;
        sp.x = spX;
        return sp;
    }

}
