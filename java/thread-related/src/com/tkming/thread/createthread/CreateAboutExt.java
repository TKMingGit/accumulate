package com.tkming.thread.createthread;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/31
 * @description 线程创建-继承Thread
 */
public class CreateAboutExt extends Thread{
    private String name;

    public CreateAboutExt(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(String.format(Thread.currentThread().getName() + ", %s like programing!", name));
    }

    public static void main(String[] args) {
        CreateAboutExt createAbout =  new CreateAboutExt("sub");
        createAbout.start();
        System.out.println(Thread.currentThread().getName() + ", main like programing!");
    }
}
