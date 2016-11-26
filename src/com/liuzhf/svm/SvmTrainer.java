package com.liuzhf.svm;

import com.liuzhf.data.entity.DataForSVM;
import com.liuzhf.svm.entity.FeatureScale;
import com.liuzhf.svm.entity.FeatureScaleResult;
import com.liuzhf.svm.entity.SvmTrainResult;
import libsvm.*;

import java.util.ArrayList;
import java.util.List;

import static libsvm.svm_parameter.C_SVC;
import static libsvm.svm_parameter.RBF;

/**
 * Created by asus on 2016/11/26.
 */
public class SvmTrainer {

    public static SvmTrainResult trainSvm(List<DataForSVM> dataList) {

        // scale data
        FeatureScaleResult featureScaleResult = scaleData(dataList);

        // organize data for svm
        svm_problem sp = constructSvmProblem(featureScaleResult.getmDataScaled());

        // traverse data to find the most suitable kernel function
        //// traverse data to find the best parameter
        ////// check data
        svm_model model = selectSvmModel(sp);

        return new SvmTrainResult(model, featureScaleResult.getmFeatureScale());
    }

    private static svm_model selectSvmModel(svm_problem sp) {
        // traverse data to find the most suitable kernel function
        //// traverse data to find the best parameter
        ////// check data
        svm_parameter param = new svm_parameter();
        param.svm_type = C_SVC;
        param.kernel_type = RBF;
        svm_model model = svm.svm_train(sp, param);
        return model;
    }

    private static FeatureScaleResult scaleData(List<DataForSVM> dataList) {

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
        return new FeatureScaleResult(result, new FeatureScale(rangeOfFeature, middFeature));
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
