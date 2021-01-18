package com.tkming.thread.volatiletest;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/11 9:31
 * @desc 暂无
 */
public class VolatileTest {
    public static void main(String[] args) {
        ThreadV t = new ThreadV();
        new Thread(t).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        System.out.println("main is end...");
    }
}
class ThreadV implements Runnable {
    boolean flag = true;
    //volatile boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag) {
            i++;
        }
        System.out.println("threadV is end...");
    }
}
