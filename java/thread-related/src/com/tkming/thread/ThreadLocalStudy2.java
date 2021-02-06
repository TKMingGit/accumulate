package com.tkming.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author Administrator
 * @create 2021/1/29 23:00
 * @desc 内存泄漏，-Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:\z-project\accumulate\java\thread-related\dump.prof
 */
public class ThreadLocalStudy2 {
    static ThreadLocal<StringBuilder> tl = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()-> {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 5000000; i++) {
                s.append("0000000000");
            }
            //占用2m的内存空间
            tl.set(s);
        }).start();
        System.gc();//gc后应该被释放掉，后面至少可以分配4次内存空间，但实际分配不到4次
        List<byte[]> bytes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("malloc heap time:" + (i+1));
            byte[] byte1 = new byte[1024*1024];
            bytes.add(byte1);
        }
    }
}
