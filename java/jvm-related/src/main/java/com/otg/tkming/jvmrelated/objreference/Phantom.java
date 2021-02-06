package com.otg.tkming.jvmrelated.objreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 15:49
 * @desc 虚引用,-Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:/a-mine/accumulate/jvm-related/dump.hprof
 */
public class Phantom {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        List<byte[]> list = new ArrayList<>();
        ReferenceQueue<StringBuilder> referenceQueue = new ReferenceQueue();
        PhantomReference<StringBuilder> pr = new PhantomReference<>(new StringBuilder(),referenceQueue);
        //虚引用get()方法永远返回null,且虚引用对象会随时被gc回收
        System.out.println("even not gc:" + pr.get());
        new Thread(() -> {
            while (true) {
                i.getAndIncrement();
                System.out.println("malloc heap time:" + i);
                byte[] by1 = new byte[1024*1024];
                list.add(by1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference reference = referenceQueue.poll();
                if (reference != null) {
                    System.out.println("---虚引用指向的对象被回收---" + reference);
                }
            }
        }).start();
    }
}
