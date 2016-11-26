package com.liuzhf.svm;

import com.liuzhf.data.entity.DataForSVM;
import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/11/26.
 */
public class SvmTrainer {

    public static svm_model trainSvm(List<DataForSVM> dataList) {

        // scale data
        List<DataForSVM> dataListScaled = scaleData(dataList);

        // organize data for svm
        svm_problem sp = constructSvmProblem(dataListScaled);

        // traverse data to find the most suitable kernel function
        //// traverse data to find the best parameter
        ////// check data

        return null;
    }

    private static List<DataForSVM> scaleData(List<DataForSVM> dataList) {

        float maxFeature = Float.MIN_VALUE;
        float minFeature = Float.MAX_VALUE;
        for(DataForSVM data: dataList) {
            for(float feature : data.getFeatures()) {
                maxFeature = Math.max(maxFeature, feature);
                minFeature = Math.min(minFeature, feature);
            }
        }
        float middFeature = (maxFeature + minFeature) / 2;
        float rangeOfFeature = maxFeature - minFeature;

        List<DataForSVM> result = new ArrayList<>();
        for(DataForSVM data : dataList) {
            float[] features = data.getFeatures();
            float[] featureScaled = new float[features.length];
            for(int i = 0; i != features.length; i++) {
                featureScaled[i] = (features[i] - middFeature) / rangeOfFeature;
            }
            result.add(new DataForSVM(data.getDate(), data.isUp(), featureScaled));
        }
        return result;
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
