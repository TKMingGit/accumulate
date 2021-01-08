package com.tkming.thread.variableshare;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/8 17:08
 * @desc 暂无
 */
public class SaleTicketsThreadRunnable {
    public static void main(String[] args) {
        Thread2 t = new Thread2();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
class Thread2 implements Runnable {
    /**每个线程卖100张票，没有共享*/
    //private int tickets = 100;
    /**static变量是共享的，所有的线程共享*/
    private static int tickets = 100;

    @Override
    public void run() {
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " selling ticket " + tickets);
            tickets--;
        }
    }
}