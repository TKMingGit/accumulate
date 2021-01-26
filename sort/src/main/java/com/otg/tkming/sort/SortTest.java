package com.otg.tkming.sort;

import com.otg.tkming.sort.util.Util;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/21 13:48
 * @desc 暂无
 */
public class SortTest {
    public static void main(String[] args) {
        int[] waitSort = new int[]{6276, 1131, 8854, 1782, 5265, 2352, 2605, 9595, 4177, 3812};
        System.out.println("before:" + Arrays.toString(waitSort));
        //quickSort(waitSort, 0, waitSort.length-1);
        mergeSort(waitSort);
        System.out.println("end:" + Arrays.toString(waitSort));
    }

    private static void quickSort(int[] args, int left, int right) {
        while (left >= right) {
            return;
        }
        int pivot = args[left];
        int i = left;
        int j = right;
        for (;;) {
            for (;j != i && args[j] > pivot; j--) {}
            for (;i != j && args[i] <= pivot; i++) {}
            if (i < j) {
                Util.swap(args, i, j);
            } else {
                break;
            }
        }
        Util.swap(args, i, left);
        quickSort(args, left, i-1);
        quickSort(args, i+1, right);

    }

    private static void mergeSort(int[] args) {
        int[] temp = new int[args.length];
        separateAndMerge(args, temp, 0, args.length-1);
    }

    private static void separateAndMerge(int[] args, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int leftEnd = (leftStart+rightEnd)/2;
        separateAndMerge(args, temp, leftStart, leftEnd);
        separateAndMerge(args, temp, leftEnd+1, rightEnd);
        merge(args, temp, leftStart, leftEnd, rightEnd);
    }

    private static void merge(int[] args, int[] temp, int leftStart, int leftEnd, int rightEnd) {
        int tempStart = 0;
        int rightStart = leftEnd+1;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (args[leftStart] <= args[rightStart]) {
                temp[tempStart++] = args[leftStart++];
            }
            else {
                temp[tempStart++] = args[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            temp[tempStart++] = args[leftStart++];
        }

        while (rightStart <= rightEnd) {
            temp[tempStart++] = args[rightStart++];
        }

        for (int i = tempStart-1; i >= 0; i--,rightEnd--) {
            args[rightEnd] = temp[i];
        }
    }

}
