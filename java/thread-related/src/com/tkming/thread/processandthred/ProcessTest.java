package com.tkming.thread.processandthred;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/8 10:50
 * @desc 启动两次main方法，是两个进程
 */
public class ProcessTest {
    public static void main(String[] args) {
        while (true) {
            int random = (int)(Math.random() * 100);
            System.out.println(random);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
