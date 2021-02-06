package com.tkming.thread;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/25
 * @description 区分线程
 */
public class ThreadLocalStudy {
    static ThreadLocal<Person> local = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //会一直打印null,因为是不同的线程，别的线程设置的值，本线程获取不到
                System.out.println(local.get());
            }
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            local.set(new Person());
        }).start();
    }
}
class Person {
    String name = "lisi";
}
