package com.otg.tkming.sort.ext.quick;

import com.otg.tkming.sort.base.insert.InsertSort;
import com.otg.tkming.sort.util.Util;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/21 13:48
 * @desc 暂无
 */
public class QuickSort {
    public static int[] sort(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        quickSort(args,0 , args.length-1);
        return args;
    }

    private static void quickSort(int[] args, int left, int right) {
        while (left >= right) {
            return;
        }
        int base = args[left];
        int i = left;
        int j = right;
        while (true) {
            while (i != j && args[j] > base){
                j--;
            }
            while (i !=j && args[i] <= base){
                i++;
            }
            if (j > i) {
                Util.swap(args, i, j);
            } else {
                break;
            }
        }
        Util.swap(args, left, j);
        quickSort(args, left, j-1);
        quickSort(args, j+1, right);
    }

    public static int[] sortPivot(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        quickSortWithPivot(args, 0, args.length-1);
        return args;
    }


    /**
     * 设置数组中位数为主元的快速排序
     * TODO：设置阈值，当待排数据小于3个的时候，直接用插入排序
     * @param args
     * @param left
     * @param right
     */
    private static void quickSortWithPivot(int[] args, int left, int right) {
        while (left >= right) {
            return;
        }
        int pivot = getPivot(args, left, right);
        int i = left;
        int j = right;
        for (;;) {
            while (i !=j && args[i] < pivot){
                i++;
            }
            while (i != j && args[j] >= pivot){
                j--;
            }

            if (i < j) {
                Util.swap(args, i, j);
            } else {
                break;
            }
        }
        Util.swap(args, i, right);
        quickSortWithPivot(args, left, i-1);
        quickSortWithPivot(args, i+1, right);
    }

    /**
     * 设置主元
     */
    private static int getPivot(int[] args, int left, int right) {
        int center = (left+right)/2;
        // 左边的和中间的比，左边的大，则交换位置
        if (args[left] > args[center]) {
            Util.swap(args, left, center);
        }
        // 交换后的左边的再和右边的比，还比右边的大，则交换位置，这个时候，左边的一定是最小元素
        if (args[left] > args[right]) {
            Util.swap(args, left, right);
        }
        //交换后的中间和右边比，如果中间的比右边的大，则交换位置，那么这时一定是: args[left] <= args[center] <= args[right]
        if (args[center] > args[right]) {
            Util.swap(args, center, right);
        }
        //将主元藏到最right-1的位置，right位置的元素一定是比主元大的
        Util.swap(args, center, right);
        return args[right];
    }

}
