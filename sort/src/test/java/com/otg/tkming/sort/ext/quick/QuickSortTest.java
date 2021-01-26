package com.otg.tkming.sort.ext.quick;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/21 15:17
 * @desc 暂无
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class QuickSortTest {
    static int[] waitSort = new int[30];

    @BeforeAll
    static void setUp() {
        for (int i = 0; i < 30; i++) {
            waitSort[i] = (int) (Math.random() * 10000);
        }
    }

    @Test
    void sort() {
        System.out.println("before: " + Arrays.toString(waitSort));
        QuickSort.sort(waitSort);
        for (int i = 0; i < waitSort.length - 1; i++) {
            int finalI = i;
            assertTrue(()->waitSort[finalI] <= waitSort[finalI +1]);
        }
        System.out.println("after: " + Arrays.toString(waitSort));
    }

    @Test
    void sortPivot() {
        System.out.println("before: " + Arrays.toString(waitSort));
        QuickSort.sortPivot(waitSort);
        for (int i = 0; i < waitSort.length - 1; i++) {
            int finalI = i;
            assertTrue(()->waitSort[finalI] <= waitSort[finalI +1]);
        }
        System.out.println("after: " + Arrays.toString(waitSort));
    }
}