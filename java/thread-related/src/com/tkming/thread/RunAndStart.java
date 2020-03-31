package com.tkming.thread;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/31
 * @description Thread中run 和 start 的区别
 */
public class RunAndStart {
    private static void test(boolean run) {
        System.out.println("**** Thread." + (run ? "run" : "start") + "() ****");
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[Thread " + Thread.currentThread().getName() + "] sub end");
        }, "sub");
        if (run) {
            thread.run();
        } else {
            thread.start();
        }
        System.out.println("[Thread " + Thread.currentThread().getName() + "] main end");
    }

    private static void threadStart() {
        test(false);
    }

    private static void threadRun() {
        test(true);
    }

    public static void main(String[] args) {
        // 在当前线程中直接执行，无需另外获取cpu时间片；结果：sub end、main end
        threadRun();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 创建线程加入当前线程组、等待获取cpu时间片后开始执行；结果：main end、sub end
        threadStart();
    }
}
