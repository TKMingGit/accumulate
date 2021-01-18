package com.tkming.thread.datastructure.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/13 14:22
 * @desc 暂无
 */
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        Deque<String> unsafe = new ArrayDeque<>();
        ConcurrentLinkedQueue<String> safe = new ConcurrentLinkedQueue<>();
        Queue<String> safe2 = new ArrayBlockingQueue<>(100);

        QueueSub t1 = new QueueSub(unsafe);
        QueueSub t2 = new QueueSub(safe);
        QueueSub t3 = new QueueSub(safe2);

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
        System.out.println("unsafe size:" + t1.queue.size());
        System.out.println("safe1 size:" + t2.queue.size());
        System.out.println("safe2 size:" + t3.queue.size());


        System.out.println("unsafe content:");
        t1.queue.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        System.out.println("safe content:");
        t2.queue.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        System.out.println("safe2 content:");
        t3.queue.forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
    }
}

class QueueSub implements Runnable {
    public Queue queue;

    public QueueSub(Queue queue) {
        this.queue = queue;
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
            queue.add(Thread.currentThread().getName() + "-" + i);
            i++;
        }
    }
}
