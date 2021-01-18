package com.tkming.thread.datastructure.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/13 14:04
 * @desc 暂无
 */
public class ListTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> unsafe = new ArrayList<>();
        List<String> safe = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> safe2 = new CopyOnWriteArrayList<>();

        ListSub t1 = new ListSub(unsafe);
        ListSub t2 = new ListSub(safe);
        ListSub t3 = new ListSub(safe2);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t1, String.valueOf(i));
            t.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t2, String.valueOf(i));
            t.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t3, String.valueOf(i));
            t.start();
        }
        Thread.sleep(2000);
        System.out.println("unsafe size:" + t1.list.size());
        System.out.println("safe1 size:" + t2.list.size());
        System.out.println("safe2 size:" + t3.list.size());


        System.out.println("unsafe content:");
        t1.list.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        System.out.println("safe content:");
        t2.list.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        System.out.println("safe2 content:");
        t3.list.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
    }
}

class ListSub implements Runnable {
    public List<String> list;

    public ListSub(List<String> list) {
        this.list = list;
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
            list.add(Thread.currentThread().getName());
            i++;
        }
    }
}
