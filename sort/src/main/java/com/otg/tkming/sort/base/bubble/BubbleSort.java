package com.otg.tkming.sort.base.bubble;

import com.otg.tkming.sort.util.Util;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/20 10:11
 * @desc 暂无
 */
public class BubbleSort {
    /**
     * 普通实现：按照原理做n次排序
     */
    public static int[] sort(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length-i-1; j++) {
                if (args[j] > args[j+1]) {
                    Util.swap(args, j, j+1);
                }
            }
        }
        return args;
    }

    /**
     * 更好实现：每趟排序查看数组是否有序
     */
    public static int[] betterSort(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        for (int i = 0; i < args.length; i++) {
            boolean sorted = true;
            // 一趟冒泡排序
            for (int j = 0; j < args.length-i-1; j++) {
                if (args[j] > args[j+1]) {
                    Util.swap(args, j, j+1);
                    //发生了交换，标识置为false
                    sorted = false;
                }
            }
            //全程无交换，所有元素已经有序,停止循环
            if (sorted) {
                break;
            }
        }
        return args;
    }
}
