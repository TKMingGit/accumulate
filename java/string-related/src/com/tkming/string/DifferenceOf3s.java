package com.tkming.string;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/23
 * @description
 * 1.运行速度:StringBuilder >StringBuffer >String
 * String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，所以速度要比String快很多。
 *
 * 2.线程安全:StringBuilder是线程不安全的，而StringBuffer是线程安全的
 * 如果一个StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法可以带有synchronized关键字，所以可以保证线程是安全的，但StringBuilder的方法则没有该关键字，所以不能保证线程安全，有可能会出现一些错误的操作。所以如果要进行的操作是多线程的，那么就要使用StringBuffer，但是在单线程的情况下，还是建议使用速度比较快的StringBuilder。
 *
 * 3.使用场景
 *  String：适用于少量的字符串操作的情况
 *  StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
 *  StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
 */
public class DifferenceOf3s extends Thread{
    StringBuilder builder = new StringBuilder();
    StringBuffer buffer = new StringBuffer();
    int cycleTimes = 10;
    @Override
    public void run() {
        for (int i = 0; i < cycleTimes; i++) {
            builder.append(i);
            buffer.append(i);
        }
    }

    /**
     * 通过多线程同时改变同一个变量，看最后得到的字符串的长度
     * 1.测试StringBuilder是线程不安全的
     * 2.测试StringBuffer是线程安全的
    */
    public static void main(String[] args) throws InterruptedException {
        DifferenceOf3s difference = new DifferenceOf3s();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        new Thread(difference).start();
        Thread.sleep(1000);
        System.out.println("builder:" + difference.builder + ",length:" + difference.builder.length());
        System.out.println("buffer:" + difference.buffer + ",length:" + difference.buffer.length());
    }
}

