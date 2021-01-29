package com.otg.tkming.jvmrelated.jvmparam;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 10:24
 * vm启动参数设置：-Xss1m -Xmx=10m
 * vm启动参数设置：-Xss5m -Xmx=10m
 */
public class StackWithMethod {
    private int len = 1;
    private void f1(){
        len++;
        System.out.println(len);
        f1(); //递归调用
    }

    public static void main(String[] args) {
        StackWithMethod stackWithMethodProperties = new StackWithMethod();
        stackWithMethodProperties.f1();
    }
}
