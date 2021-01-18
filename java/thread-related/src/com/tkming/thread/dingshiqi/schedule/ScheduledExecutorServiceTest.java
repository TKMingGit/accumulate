package com.tkming.thread.dingshiqi.schedule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/14 15:28
 * @desc 暂无
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException {
        //executeAtFixedTime();
        //executeAtFixedRate();
        executeAtFixedDelay();
    }

    /**
     * 指定程序在指定时间执行任务
     * @throws InterruptedException
     */
    private static void executeAtFixedTime() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": I'm running at " + new Date().toLocaleString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1, TimeUnit.SECONDS);
        Thread.sleep(10000);
        executor.shutdown();
    }


    /**
     * 周期任务 固定速率 是以上一个任务开始的时间计时，period时间过去后，检测上一个任务是否执行完毕，
     * 如果上一个任务执行完毕，则当前任务立即执行，如果上一个任务没有执行完毕，则需要等上一个任务执行完毕后立即执行
     * @throws InterruptedException
     */
    private static void executeAtFixedRate() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": I'm running at " + new Date().toLocaleString());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
        Thread.sleep(20000);
        executor.shutdown();
    }

    /**
     * 周期任务， 固定延时，是以上一个任务结束时开始计时，period 时间过去后，立即执行
     * @throws InterruptedException
     */
    private static void executeAtFixedDelay() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": I'm running at " + new Date().toLocaleString());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 3, TimeUnit.SECONDS);
        Thread.sleep(20000);
        executor.shutdown();
    }
}
