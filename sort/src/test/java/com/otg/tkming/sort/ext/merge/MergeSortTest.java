package com.otg.tkming.sort.ext.merge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/21 10:27
 * @desc 暂无
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MergeSortTest {
    static int[] waitSort = new int[10];

    @BeforeAll
    static void setUp() {
        for (int i = 0; i < 10; i++) {
            waitSort[i] = (int) (Math.random() * 10000);
        }
    }

    @Test
    void sort() {
        System.out.println("before: " + Arrays.toString(waitSort));
        MergeSort.sort(waitSort);
        for (int i = 0; i < waitSort.length - 1; i++) {
            int finalI = i;
            assertTrue(()->waitSort[finalI] <= waitSort[finalI +1]);
        }
        System.out.println("after: " + Arrays.toString(waitSort));
    }
}