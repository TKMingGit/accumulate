package com.tkming.thread.pool.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/12 16:24
 * @desc 用线程池计算1带100的和
 */
public class Calculator {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 4, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Calc c = new Calc(i * 10 + 1, i * 10 + 10);
            Future future = pool.submit(c);
            futures.add(future);
        }

        while (pool.getCompletedTaskCount() < futures.size()) {
            for (int i = 0; i < futures.size(); i++) {
                Future<Integer> future = futures.get(i);
                System.out.println("task: " + i + ",is done: " + future.isDone());
            }
            Thread.sleep(500);
        }

        int total = 0;
        for (int i = 0; i < futures.size(); i++) {
            int sum = futures.get(i).get();
            System.out.println("task: " + i + ",sum: " + sum);
            total += sum;
        }
        System.out.println("total is: " + total);
        pool.shutdown();
    }
}

class Calc implements Callable<Integer> {
    private int start;
    private int end;

    public Calc(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = (start + end) * (end - start + 1) / 2;
        System.out.println();
        Thread.sleep(new Random().nextInt(1000));
        return sum;
    }
}
