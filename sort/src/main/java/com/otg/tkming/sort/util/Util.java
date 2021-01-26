package com.otg.tkming.sort.util;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/20 13:09
 * @desc 暂无
 */
public class Util {
    public static void swap(int[] args, int i, int j) {
        int temp = args[i];
        args[i] = args[j];
        args[j] = temp;
    }
}
