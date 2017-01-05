package com.liuzhf.dl4j;

import com.liuzhf.data.DataWriter;
import org.datavec.api.records.reader.SequenceRecordReader;
import org.datavec.api.records.reader.impl.csv.CSVSequenceRecordReader;
import org.datavec.api.split.NumberedFileInputSplit;
import org.deeplearning4j.datasets.datavec.SequenceRecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.GradientNormalization;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.GravesLSTM;
import org.deeplearning4j.nn.conf.layers.RnnOutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerStandardize;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.io.IOException;

/**
 * Created by asus on 2017/1/2.
 */
public class NeuralNetwork {

    private static final int NODE_CNT = 36;

    public static void studyStock() {
        // 读取数据
        SequenceRecordReader featureReader = new CSVSequenceRecordReader(0, DataWriter.CSV_SPERATOR);
        SequenceRecordReader labelReader = new CSVSequenceRecordReader(0, DataWriter.CSV_SPERATOR);
        SequenceRecordReader featureReaderTest = new CSVSequenceRecordReader(0, DataWriter.CSV_SPERATOR);
        SequenceRecordReader labelReaderTest = new CSVSequenceRecordReader(0, DataWriter.CSV_SPERATOR);

        try {
            featureReader.initialize(new NumberedFileInputSplit("train/train_%d.csv", 0, 2015));
            labelReader.initialize(new NumberedFileInputSplit("train/train_label_%d.csv", 0, 2015));
            featureReaderTest.initialize(new NumberedFileInputSplit("test/test_%d.csv", 0, 867));
            labelReaderTest.initialize(new NumberedFileInputSplit("test/test_label_%d.csv", 0, 867));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DataSetIterator trainData = new SequenceRecordReaderDataSetIterator(featureReader, labelReader, 100, 2, false, SequenceRecordReaderDataSetIterator.AlignmentMode.ALIGN_END);

        // normalization
        DataNormalization normalizer = new NormalizerStandardize();
        normalizer.fit(trainData);              //Collect training data statistics
        trainData.reset();
        trainData.setPreProcessor(normalizer);

        DataSetIterator testData = new SequenceRecordReaderDataSetIterator(featureReaderTest, labelReaderTest, 100, 2, false, SequenceRecordReaderDataSetIterator.AlignmentMode.ALIGN_END);
        testData.setPreProcessor(normalizer);

        // train
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(123)    //Random number generator seed for improved repeatability. Optional.
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT).iterations(1)
                .weightInit(WeightInit.XAVIER)
                .updater(Updater.NESTEROVS).momentum(0.9)
                .learningRate(0.005)
                .gradientNormalization(GradientNormalization.ClipElementWiseAbsoluteValue)  //Not always required, but helps with this data set
                .gradientNormalizationThreshold(0.5)
                .list()
                .layer(0, new GravesLSTM.Builder().activation("tanh").nIn(6).nOut(NODE_CNT).build())
                .layer(1, new GravesLSTM.Builder().activation("tanh").nIn(NODE_CNT).nOut(NODE_CNT).build())
                .layer(2, new GravesLSTM.Builder().activation("tanh").nIn(NODE_CNT).nOut(NODE_CNT).build())
                .layer(3, new GravesLSTM.Builder().activation("tanh").nIn(NODE_CNT).nOut(NODE_CNT).build())
                .layer(4, new RnnOutputLayer.Builder(LossFunctions.LossFunction.MCXENT)
                        .activation("softmax").nIn(NODE_CNT).nOut(2).build())
                .pretrain(false).backprop(true).build();

        MultiLayerNetwork net = new MultiLayerNetwork(conf);
        net.init();

        net.setListeners(new ScoreIterationListener(20));   //Print the score (loss function value) every 20 iterations


        int nEpochs = 100;
        String str = "Test set evaluation at epoch %d: Accuracy = %.2f, F1 = %.2f";
        for (int i = 0; i < nEpochs; i++) {
            net.fit(trainData);

            //Evaluate on the test set:
            Evaluation evaluation = net.evaluate(testData);
            System.out.print(String.format(str, i, evaluation.accuracy(), evaluation.f1()));

            testData.reset();
            trainData.reset();
        }

        System.out.print("----- Example Complete -----");
    }
}
