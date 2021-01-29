package com.otg.tkming.jvmrelated.jvmparam;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 9:52
 * @desc vm启动参数设置：-Xmx1m
 */
public class Heap {
    public static void main(String[] args) {
        List<HeapObj> list = new ArrayList<>();
        while (true) {
            list.add(new HeapObj());
            System.out.println(list.size());
        }
    }
}
class HeapObj {
}