package com.tkming.thread.pool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/31
 * @description 单线程池，核心线程数1，最大线程数1，不处理任务的非核心线程存活时间为0，
 * 无界队列LinkedBlockingQueue的初始大小为Integer.MAX_VALUE，队列元素过多容易导致oom
 */
public class PoolSingle {
    public static void main(String[] args) {
        ExecutorService single = Executors.newSingleThreadExecutor();
        single.execute(new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("single");
        }));
        single.shutdown();
        //shutdown不再往队列添加任务，shutdownNow会试图终止正在执行的任务
        /*single.shutdownNow();*/
        System.out.println("main continue.");
        ExecutorService single2 = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
        single2.execute(new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("single2");
        }));
        single2.shutdown();
        System.out.println("main continue..");
        ExecutorService single3 = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
        single3.execute(new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("single3");
        }));
        single3.shutdown();
        System.out.println("main continue...");
    }
}
