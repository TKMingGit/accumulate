package com.otg.tkming.jvmrelated.jvmparam;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 10:24
 * @desc vm启动参数设置：-Xss1m -Xmx=10m
 */
public class StackWithMethodProperties {
    private int len = 1;
    private void f1(){
        long a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
        a1=a2=a3=a4=a5=a6=a7=a8=a9=a10=0;
        len++;
        System.out.println(len);
        f1(); //递归调用
    }

    public static void main(String[] args) {
        StackWithMethodProperties stackWithMethodProperties = new StackWithMethodProperties();
        stackWithMethodProperties.f1();
    }
}
