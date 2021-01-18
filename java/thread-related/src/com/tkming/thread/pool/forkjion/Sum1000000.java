package com.tkming.thread.pool.forkjion;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/13 10:40
 * @desc 使用
 */
public class Sum1000000 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = new ForkJoinPool();
        SumTask sumTask = new SumTask(1,1000000);
        ForkJoinTask<Integer> task = pool.submit(sumTask);
        do {
            System.out.println("thread count:" + pool.getActiveThreadCount());
            System.out.println("parallel:" + pool.getActiveThreadCount());
            Thread.sleep(50);
        } while (!task.isDone());

        System.out.println(task.get().toString());
    }

}
class SumTask extends RecursiveTask<Integer> {
    int start;
    int end;
    int threadHold = 5;
    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start <= threadHold) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // “分裂”子任务
            int middle = (start + end) / 2;
            SumTask sub1 = new SumTask(start, middle);
            SumTask sub2 = new SumTask(middle + 1, end);
            // invokeAll会并行运行两个子任务:
            invokeAll(sub1, sub2);
            // 获得子任务的结果:
            int sumSub1 = sub1.join();
            int sumSub2 = sub2.join();
            // 汇总结果:
            sum = sumSub1 + sumSub2;
        }
        return sum;
    }
}