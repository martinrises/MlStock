package com.liuzhf.data;

import com.liuzhf.data.entity.DataForSVM;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by asus on 2016/11/26.
 */
public class DataWriter {

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
}
