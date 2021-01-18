package com.tkming.thread.interrupt;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/11 16:24
 * @desc 线程主动停止
 */
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Rupt rupt = new Rupt();
        Vola vola = new Vola();

        rupt.start();
        vola.start();
        Thread.sleep(2000);

        rupt.interrupt();
        vola.flag = false;
        System.out.println("main is existing....");
    }
}

/**interrupt打断*/
class Rupt extends Thread {
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println("rupt is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        System.out.println("rupt is existing...");
    }
}

/**共享变量打断*/
class Vola extends Thread {
    volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println("vola is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("vola is existing...");
    }
}