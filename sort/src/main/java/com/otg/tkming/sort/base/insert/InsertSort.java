package com.otg.tkming.sort.base.insert;

import com.otg.tkming.sort.util.Util;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/20 13:28
 * @desc 暂无
 */
public class InsertSort {
    public static int[] sort(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        for (int i = 0; i < args.length; i++) {
            for (int j = i; j > 0; j--) {
                if (args[j] > args[j-1]) {
                    break;
                }
                Util.swap(args, j, j-1);
            }
        }
        return args;
    }


    public static int[] sortBetter(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        for (int i = 1; i < args.length; i++) {
            int temp = args[i];
            int j;
            for (j = i; j > 0 && temp < args[j-1]; j--) {
                args[j] = args[j-1];
            }
            args[j] = temp;
        }
        return args;
    }

    public static int[] sortWithStartAndEnd(int[] args, int start, int end) {
        if (args == null || args.length == 0) {
            return args;
        }
        for (int i = start + 1; i <= end; i++) {
            int temp = args[i];
            int j;
            for (j = i; j > start && temp < args[j-1]; j--) {
                args[j] = args[j-1];
            }
            args[j] = temp;
        }
        return args;
    }
}
