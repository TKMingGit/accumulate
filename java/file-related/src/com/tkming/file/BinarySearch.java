package com.tkming.file;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/29 15:10
 * @desc 暂无
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] as = new int[100000000];
        int i = 1;
        while (true && i <= as.length) {
            as[i - 1] = i;
            i++;
        }
        int target = (int) (Math.random() * 100000000);
        long start = System.currentTimeMillis();
        int targetIndex = commonSearch(as, target);
        System.out.println("commonSearch: " + target+ ", targetIndex: " + targetIndex + ", cost: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        targetIndex = binarySearch(as, target);
        System.out.println("binarySearch: " + target+ ",targetIndex: " + targetIndex + ",cost: " + (System.currentTimeMillis() - start));
    }

    private static int commonSearch(int[] as, int target) {
        int index = 0;
        for (int i = 0; i < as.length; i++) {
            if (as[i] == target) {
                index = i;
            }
        }
        return index;
    }

    private static int binarySearch(int[] as, int target) {
        int low = 0;
        int high = as.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = as[mid];
            if (target < midVal) {
                high = mid - 1;
            } else if (target > midVal) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
