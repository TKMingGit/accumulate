package com.tkming.thread.variableshare.saletickets;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/8 17:08
 * @desc 使用同一个线程对象
 */
public class SaleTicketsRunnable {
    public static void main(String[] args) {
        Thread2 t = new Thread2();
        //下面用的是同一个t变量，共享变量，如果是4个不同的t对象，那么就不会共享变量
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
class Thread2 implements Runnable {
    /**线程内卖100张票，没有共享*/
    private int tickets = 100;
    /**static变量是共享的，所有的线程共享*/
    //private static int tickets = 100;

    @Override
    public void run() {
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " selling ticket " + tickets);
            tickets--;
        }
    }
}