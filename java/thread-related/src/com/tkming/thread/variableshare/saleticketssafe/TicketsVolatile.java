package com.tkming.thread.variableshare.saleticketssafe;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/11 9:55
 * @desc 此例中变量锁和代码块锁要一个就行
 */
public class TicketsVolatile {
    public static void main(String[] args) {
        TicketsV t = new TicketsV();
        new Thread(t, "thread-1").start();
        new Thread(t, "thread-2").start();
        new Thread(t, "thread-3").start();
        new Thread(t, "thread-4").start();
    }
}
class TicketsV implements Runnable {
    volatile int tickets = 100;
    String s1 = new String("");

    @Override
    public void run() {
        while (true) {
            //变量加锁，只能加在对象上
            synchronized (s1) {
                sale();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tickets == 0) {
                break;
            }
        }
    }

    /**
     * 代码块加锁
     */
    synchronized void sale() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " is selling ticket: " + tickets--);
        }
    }
}