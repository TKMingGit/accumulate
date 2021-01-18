package com.tkming.thread.pool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/31
 * @description 缓存线程池，核心线程数0，最大线程数Integer.MAX_VALUE，不处理任务的非核心线程存活时间为60s，
 * SynchronousQueue，非核心线程启动过多容易导致oom
 */
public class PoolCache {
    public static void main(String[] args) {
        ExecutorService single = Executors.newCachedThreadPool();
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
