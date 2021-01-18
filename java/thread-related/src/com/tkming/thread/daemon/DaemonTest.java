package com.tkming.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/11 16:45
 * @desc 暂无
 */
public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        D1 d1 = new D1();
        //设置为守护线程,设置后main线程结束，d1结束
        d1.setDaemon(true);
        d1.start();
        Thread.sleep(2000);
        System.out.println("main is ending...");
    }
}

class D1 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("d1 is running...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}