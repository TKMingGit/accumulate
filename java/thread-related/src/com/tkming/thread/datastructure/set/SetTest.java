package com.tkming.thread.datastructure.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/13 14:22
 * @desc 暂无
 */
public class SetTest {
    public static void main(String[] args) throws InterruptedException {
        Set<String> unsafe = new HashSet<>();
        Set<String> safe = Collections.synchronizedSet(new HashSet<>());
        CopyOnWriteArraySet<String> safe2 = new CopyOnWriteArraySet<>();

        SetSub t1 = new SetSub(unsafe);
        SetSub t2 = new SetSub(safe);
        SetSub t3 = new SetSub(safe2);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t1);
            t.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t2);
            t.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t3);
            t.start();
        }

        Thread.sleep(2000);
        System.out.println("unsafe size:" + t1.set.size());
        System.out.println("safe1 size:" + t2.set.size());
        System.out.println("safe2 size:" + t3.set.size());


        System.out.println("unsafe content:");
        t1.set.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        System.out.println("safe content:");
        t2.set.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        System.out.println("safe2 content:");
        t3.set.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
    }
}

class SetSub implements Runnable {
    public Set<String> set;

    public SetSub(Set<String> set) {
        this.set = set;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            set.add(Thread.currentThread().getName() + "-" + i);
            i++;
        }
    }
}
