package com.otg.tkming.jvmrelated.objreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 15:49
 * @desc 虚引用,-Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:/a-mine/accumulate/jvm-related/dump.hprof
 */
public class Phantom {
    public static void main(String[] args) {
        ReferenceQueue<StringBuilder> referenceQueue = new ReferenceQueue();
        MyThread myThread = new MyThread(referenceQueue);
        myThread.setDaemon(true);
        myThread.start();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            s1.append("0000000000");
        }
        PhantomReference<StringBuilder> s2 = new PhantomReference<>(s1,referenceQueue);
        s1 = null;
        //可能没有gc,s2也会被置为null
        System.out.println("even not gc:" + s2.get());
        System.gc();
        //再申请分配3m的内存,内存分配成功
        byte[] b = new byte[1024*1024*3];
    }
}
class MyThread extends Thread {
    ReferenceQueue<StringBuilder> referenceQueue;
    public MyThread(ReferenceQueue<StringBuilder> referenceQueue) {
        this.referenceQueue = referenceQueue;
    }

    @Override
    public void run() {
        System.out.println(LocalDateTime.now() + " my thread start");
        while (true) {
            if (referenceQueue != null) {
                try {
                    PhantomReference<StringBuilder> phantomReference = (PhantomReference<StringBuilder>) referenceQueue.remove();
                    if (phantomReference != null) {
                        System.out.println(LocalDateTime.now() + " object is removed");
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}