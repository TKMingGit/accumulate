package com.otg.tkming.jvmrelated.jvmparam;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 10:24
 * @desc vm启动参数设置：-Xss100k -Xmx=10m
 */
public class StackWithThread {
    public static void main(String[] args) {
        int num = 0;
        while (true) {
            num++;
            System.out.println(num);
            new HelloThread().start();
        }
    }
}

class HelloThread extends Thread {
    @Override
    public void run(){
        long a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
        a1=a2=a3=a4=a5=a6=a7=a8=a9=a10=0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
