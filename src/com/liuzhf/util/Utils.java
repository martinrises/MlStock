package com.liuzhf.util;

/**
 * Created by asus on 2016/11/19.
 */
public class Utils {
    public static void swap(Object[] arr, int ix1, int ix2) {
        Object temp = arr[ix1];
        arr[ix1] = arr[ix2];
        arr[ix2] = temp;
    }
}
