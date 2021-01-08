package com.tkming.thread.createthread;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/31
 * @description 线程创建-实现Runnable接口
 */
public class CreateAboutImpl implements Runnable{
    private String name;

    public CreateAboutImpl(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(String.format(Thread.currentThread().getName() + ", %s like programing!", name));
    }

    public static void main(String[] args) {
        CreateAboutImpl createAbout =  new CreateAboutImpl("sub");
        Thread thread = new Thread(createAbout);
        thread.start();
        System.out.println(Thread.currentThread().getName() + ", main like programing!");
    }
}
