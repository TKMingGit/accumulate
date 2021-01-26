package com.otg.tkming.sort.base.select;

import com.otg.tkming.sort.util.Util;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/20 13:05
 * @desc 暂无
 */
public class SelectSort {
    public static int[] sort(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        for (int i = 0; i < args.length; i++) {
            int minIndex = i;
            for (int j = i; j < args.length; j++) {
                if (args[j] < args[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Util.swap(args, i, minIndex);
            }
        }
        return args;
    }
}
