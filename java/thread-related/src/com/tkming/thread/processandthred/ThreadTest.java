package com.tkming.thread.processandthred;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/8 10:54
 * @desc 启动一次main方法，main线程和MyThread线程在同一个进程中执行
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        while (true) {
            int random = (int)(Math.random() * 100);
            System.out.println("main:" + random);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            int random = (int)(Math.random() * 100);
            System.out.println("myThread:" + random);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
