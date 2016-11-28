package com.liuzhf.data;

import com.liuzhf.data.entity.RawDataItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/11/19.
 */
public class DataReader {

    public static List<RawDataItem> readData(String path){
        BufferedReader in = null;
        List<RawDataItem> datas = new ArrayList<>();
        try {
            in = new BufferedReader(new FileReader(path));
            String line;
            while((line = in.readLine()) != null){
                if(line.trim().equals("")){
                     continue;
                }
                datas.add(new RawDataItem(splitStr(line)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return datas;
    }


    private static final int INDEX_DATE = 0;
    private static final int INDEX_TIME = 1;
    private static final int INDEX_VOLUME = 2;
    private static final int INDEX_OPEN_PX = 3;
    private static final int INDEX_LOW_PX = 4;
    private static final int INDEX_HIGH_PX = 5;
    private static final int INDEX_CLOSING_PX = 6;
    private static final int INDEX_TURNOVER = 7;
    private static String[] splitStr(String str) {
        String[] split = str.split(",");
        String[] originResult = new String[split.length + 1];

        String[] temp = split[0].split(" ");
        System.arraycopy(temp, 0, originResult, 0, temp.length);
        System.arraycopy(split, 1, originResult, temp.length, split.length - 1);

        String[] result = new String[originResult.length];
        result[0] = originResult[INDEX_DATE];
        result[1] = originResult[INDEX_TIME];
        result[2] = originResult[INDEX_HIGH_PX];
        result[3] = originResult[INDEX_LOW_PX];
        result[4] = originResult[INDEX_OPEN_PX];
        result[5] = originResult[INDEX_CLOSING_PX];
        result[6] = originResult[INDEX_VOLUME];
        result[7] = originResult[INDEX_TURNOVER];
        return result;
    }
}
