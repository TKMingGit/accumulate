package com.tkming.thread.dingshiqi.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/14 15:01
 * @desc 暂无
 */
public class TimerTest {
    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();

        System.out.println("当前时间：" + new Date().toLocaleString());
        MyTask myTask = new MyTask();
        timer.scheduleAtFixedRate(myTask, 1000, 2000);
        Thread.sleep(10000);
        myTask.cancel();
        System.out.println("===========================");

        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, now.get(Calendar.SECOND) + 3);
        Date runTime = now.getTime();
        MyTask2 myTask2 = new MyTask2();
        timer.scheduleAtFixedRate(myTask2, runTime, 3000);
        Thread.sleep(20000);
        myTask2.cancel();
        System.out.println("===========================");

        Thread.sleep(1000);
        timer.cancel();
        System.out.println("main end");

    }
}

class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("运行了，时间为：" + new Date());
    }
}

class MyTask2 extends TimerTask {
    @Override
    public void run() {
        System.out.println("运行了，时间为：" + new Date());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}