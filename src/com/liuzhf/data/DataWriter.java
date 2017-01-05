package com.liuzhf.data;

import com.liuzhf.data.entity.DataForRNN;
import com.liuzhf.data.entity.DataForSVM;
import com.liuzhf.data.entity.RawDataItem;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by asus on 2016/11/26.
 */
public class DataWriter {

    public final static String CSV_SPERATOR = ",";

    public static void checkAndWriteFile(String filename, List<DataForSVM> dataList) {
        File f = new File("./" + filename);
        PrintWriter writer = null;
        if(!f.exists()) {
            try {
                f.createNewFile();

                writer = new PrintWriter(filename, "UTF-8");
                for(DataForSVM data : dataList) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(data.isUp() ? "1" : "-1").append(" ");
                    double[] features = data.getFeatures();
                    for(int i = 0; i != features.length; i++) {
                        sb.append((i + 1)).append(":").append(features[i]).append(" ");
                    }
                    writer.println(sb.toString());
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(writer != null) {
                    writer.close();
                }
            }
        }
    }

    public static void checkAndWriteFileWithDate(String filename, List<DataForSVM> dataList) {
        File f = new File("./" + filename);
        PrintWriter writer = null;
        if(!f.exists()) {
            try {
                f.createNewFile();

                writer = new PrintWriter(filename, "UTF-8");
                for(DataForSVM data : dataList) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(data.getDate()).append(" ");
                    sb.append(data.isUp() ? "1" : "-1").append(" ");
                    double[] features = data.getFeatures();
                    for(int i = 0; i != features.length; i++) {
                        sb.append((i + 1)).append(":").append(features[i]).append(" ");
                    }
                    writer.println(sb.toString());
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(writer != null) {
                    writer.close();
                }
            }
        }
    }

    public static void checkAndWriteFiles(String dirName, List<DataForRNN> datas) {
        File dir = new File(dirName);
        if(!dir.exists()) {
            dir.mkdir();
        }

        int size = datas.size();
        for(int i = 0; i != size; i++) {
            DataForRNN data = datas.get(i);
            String featureFilename = "./" + dirName + "/" + dirName + "_" + i + ".csv";
            String labelFilename = "./" + dirName + "/" + dirName + "_label_" + i + ".csv";

            writeFeatureFiles(data, featureFilename);
            writeLableFiles(data, labelFilename);
        }
    }

    private static void writeLableFiles(DataForRNN data, String filename) {
        File f = new File(filename);
        PrintWriter writer = null;
        try {
            f.createNewFile();
            writer = new PrintWriter(filename, "UTF-8");
            writer.print(data.getmLable());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
    }

    private static void writeFeatureFiles(DataForRNN data, String filename) {
        File f = new File(filename);
        PrintWriter writer = null;
        try {
            f.createNewFile();
            writer = new PrintWriter(filename, "UTF-8");
            List<RawDataItem> rawItems = data.getmDataPerDay().getRawItems();
            StringBuilder sb = new StringBuilder();
            for(RawDataItem rawData : rawItems) {
                // mHighPx, mLowPx, mOpeningPx, mClosingPx; mTotalVolumeTraded, mTotalTurnover;
                sb.append(rawData.getmHighPx())
                        .append(CSV_SPERATOR)
                        .append(rawData.getmLowPx())
                        .append(CSV_SPERATOR)
                        .append(rawData.getmOpeningPx())
                        .append(CSV_SPERATOR)
                        .append(rawData.getmClosingPx())
                        .append(CSV_SPERATOR)
                        .append(rawData.getmTotalVolumeTraded())
                        .append(CSV_SPERATOR)
                        .append(rawData.getmTotalTurnover())
                        .append("\n");
            }
            writer.print(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
    }
}
