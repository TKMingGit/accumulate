package com.tkming.thread.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/14 13:41
 * @desc
 *
 * 有家奶茶店，点单有时需要排队
 * 假设想买奶茶的人如果看到需要排队，就决定不买
 * 又假设奶茶店有老板和多名员工，记单方式比较原始，只有一个订单本
 * 老板负责写单，员工不断地查看订单本得到信息来制作奶茶，在老板写新订单时员工不能看订单本
 * 多个员工可同时看订单本，在员工看时老板不能写新订单
 *
 *
 *
 */
public class LockExample {
    private final static ReentrantLock queueLock = new ReentrantLock();
    private final static ReentrantReadWriteLock orderLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        //buyMilkTea();
        handleOrder();
    }

    private static void buyMilkTea() {
        LockExample lockExample = new LockExample();
        int student_cnt = 10;

        Thread[] students = new Thread[student_cnt];
        for (int i = 0; i < student_cnt; i++) {
            students[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    long walkingTime = new Random().nextInt(1000);
                    try {
                        Thread.sleep(walkingTime);
                        lockExample.tryBuyMilkTea();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            students[i].start();
        }
    }

    private void tryBuyMilkTea() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            if (queueLock.tryLock()) {
                long thinkingTime = new Random().nextInt(500);
                Thread.sleep(thinkingTime);
                System.out.println(Thread.currentThread().getName() + ": 来一杯珍珠奶茶，不要珍珠");
                flag = false;
                queueLock.unlock();
            } else {
                System.out.println(Thread.currentThread().getName() + ": 再等等");
            }

            if (flag) {
                Thread.sleep(1000);
            }
        }
    }

    private static void handleOrder() {
        LockExample lockExample = new LockExample();
        Thread boss = new Thread(() -> {
            while (true) {
                try {
                    lockExample.addOrder();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long waitingTime = new Random().nextInt(1000);
                try {
                    Thread.sleep(waitingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        boss.start();
        
        int staff_cnt = 3;
        Thread[] staff = new Thread[staff_cnt];
        for (int i = 0; i < staff_cnt; i++) {
            staff[i] = new Thread(() -> {
                while (true) {
                    try {
                        lockExample.viewOrder();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long waitingTime = new Random().nextInt(5000);
                    try {
                        Thread.sleep(waitingTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            staff[i].start();
        }
        
    }

    private void viewOrder() throws InterruptedException {
        orderLock.readLock().lock();
        long reading = new Random().nextInt(1000);
        Thread.sleep(reading);
        System.out.println(Thread.currentThread().getName() + ": 查看订单");
        orderLock.readLock().unlock();
    }

    private void addOrder() throws InterruptedException {
        orderLock.writeLock().lock();
        long writingTime = new Random().nextInt(1000);
        Thread.sleep(writingTime);
        System.out.println("老板新加一笔订单");
        orderLock.writeLock().unlock();
    }


}
