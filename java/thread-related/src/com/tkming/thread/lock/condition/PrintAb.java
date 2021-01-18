package com.tkming.thread.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/6 9:35
 * @desc 暂无
 */
public class PrintAb {

    ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    public int i = 0;
    public void print() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (i < 10) {
                    lock.lock();
                    try {
                        System.out.println("i:" + i + ",A");
                        i++;
                        c1.await();
                        c2.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (i < 10) {
                    lock.lock();
                    try {
                        System.out.println("i:" + i + ",B");
                        i++;
                        c1.signal();
                        c2.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        new PrintAb().print();
    }
}
