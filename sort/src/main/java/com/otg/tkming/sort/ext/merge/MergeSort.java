package com.otg.tkming.sort.ext.merge;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/21 10:04
 * @desc 合并排序
 *  第一： “分”,  就是将数组尽可能的分，一直分到原子级别。
 *  第二： “并”，将原子级别的数两两合并排序，最后产生结果。
 */
public class MergeSort {
    public static int[] sort(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        int[] tmp = new int[args.length];
        mergeSort(args, tmp, 0, args.length-1);
        return args;
    }

    /**
     * 拆分数组为原子数组,并合并
     * @param args
     * @param tmp
     * @param left
     * @param rightEnd
     */
    private static void mergeSort(int[] args, int[] tmp, int left, int rightEnd) {
        int center;
        if (left < rightEnd) {
            center = (left + rightEnd) / 2;
            mergeSort(args, tmp, left, center);
            mergeSort(args, tmp, center+1, rightEnd);
            merge(args, tmp, left, center+1, rightEnd);
        }
    }

    /**
     * 合并两个数组
     * @param args
     * @param tmp
     * @param left
     * @param right
     * @param rightEnd
     */
    private static void merge(int[] args, int[] tmp, int left, int right, int rightEnd) {
        int elements = rightEnd - left + 1;
        int tmpStart = left;
        int leftEnd = right - 1;
        while (left <= leftEnd && right <= rightEnd) {
            if (args[left] <= args[right]) {
                tmp[tmpStart++] = args[left++];
            } else {
                tmp[tmpStart++] = args[right++];
            }
        }

        while (left <= leftEnd) {
            tmp[tmpStart++] = args[left++];
        }

        while (right <= rightEnd) {
            tmp[tmpStart++] = args[right++];
        }

        for (int i = 0; i < elements; i++,rightEnd--) {
            args[rightEnd] = tmp[rightEnd];
        }
    }
}
