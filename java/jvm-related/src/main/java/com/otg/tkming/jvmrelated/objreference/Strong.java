package com.otg.tkming.jvmrelated.objreference;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 15:48
 * @desc 强引用,-Xmx5m
 */
public class Strong {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            s1.append("0000000000");
        }
        StringBuilder s2 = s1;
        s1 = null;
        System.out.println("before manual gc:" + s2.length());
        System.gc();//内存回收，无法对强引用类型回收
        System.out.println("after manual gc:" + s2.length());
        //启动heap最大内存为5m,上面list用掉一部分且为强引用,
        //再申请分配3m的内存会导致内存溢出
        byte[] bytes = new byte[1024*1024*3];
        System.out.println(s2);
    }
}
