package com.liuzhf.data;

import com.liuzhf.data.entity.RawDataItem;
import com.liuzhf.util.Utils;

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

    private static String[] splitStr(String str) {
        //date,TotalVolumeTraded,OpeningPx,LowPx,HighPx,ClosingPx,TotalTurnover
        String[] split = str.split(",");
        Utils.swap(split, 1, 5);
        String[] result = new String[split.length + 1];

        String[] temp = split[0].split(" ");
        // date , close, open, low, high, volume, turnover
        System.arraycopy(temp, 0, result, 0, temp.length);
        Utils.swap(split, 1, 4);
        Utils.swap(split, 2, 3);
        System.arraycopy(split, 1, result, temp.length, split.length - 1);
        return result;
    }
}
