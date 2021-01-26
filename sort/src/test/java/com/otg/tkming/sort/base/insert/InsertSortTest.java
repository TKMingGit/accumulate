package com.otg.tkming.sort.base.insert;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/20 13:53
 * @desc 暂无
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class InsertSortTest {
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
        InsertSort.sort(waitSort);
        for (int i = 0; i < waitSort.length - 1; i++) {
            int finalI = i;
            assertTrue(()->waitSort[finalI] <= waitSort[finalI +1]);
        }
        System.out.println("after: " + Arrays.toString(waitSort));
    }

    @Test
    void sortBetter() {
        System.out.println("before: " + Arrays.toString(waitSort));
        InsertSort.sortBetter(waitSort);
        for (int i = 0; i < waitSort.length - 1; i++) {
            int finalI = i;
            assertTrue(()->waitSort[finalI] <= waitSort[finalI +1]);
        }
        System.out.println("after: " + Arrays.toString(waitSort));
    }

    @Test
    void sortWithStartAndSize() {
        System.out.println("before: " + Arrays.toString(waitSort));
        int start = 5;
        int end = 9;
        InsertSort.sortWithStartAndEnd(waitSort, start, end);
        for (int i = 0; i < waitSort.length - 1; i++) {
            if (i < start) {
                continue;
            }
            int finalI = i;
            assertTrue(()->waitSort[finalI] <= waitSort[finalI +1]);
        }
        System.out.println("after: " + Arrays.toString(waitSort));
    }
}