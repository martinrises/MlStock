package com.liuzhf;

import com.liuzhf.data.DataFactory;
import com.liuzhf.data.DataWriter;
import com.liuzhf.data.entity.DataForRNN;
import com.liuzhf.data.entity.DataForSVM;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<DataForRNN> dataForRNN = DataFactory.getDataForRNN();
        List<DataForRNN> dataforTraining = new ArrayList<>();
        List<DataForRNN> dataforTest = new ArrayList<>();
        int size = dataForRNN.size();
        int i = size * 7 /10;
        dataforTraining.addAll(dataForRNN.subList(0, i));
        dataforTest.addAll(dataForRNN.subList(i+1 , size));

        DataWriter.checkAndWriteFiles("train", dataforTraining);

    }
}
