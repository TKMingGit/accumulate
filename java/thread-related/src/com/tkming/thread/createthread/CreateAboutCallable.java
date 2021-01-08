package com.tkming.thread.createthread;

import java.util.concurrent.*;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/31
 * @description 线程创建-实现Callable
 */
public class CreateAboutCallable implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(5000);
        return "i'm like programing!";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CreateAboutCallable createAboutCallable = new CreateAboutCallable();
        FutureTask futureTask = new FutureTask(createAboutCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("main continue");
        String msg = (String) futureTask.get(1000, TimeUnit.MILLISECONDS);
        System.out.println(msg);
    }
}
