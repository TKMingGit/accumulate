package com.otg.tkming.jvmrelated.objreference;

import java.lang.ref.SoftReference;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 15:48
 * @desc 软引用,-Xmx5m
 */
public class Soft {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            s1.append("0000000000");
        }
        SoftReference<StringBuilder> s2 = new SoftReference<>(s1);
        s1 = null;
        System.out.println("before manual gc:" + s2.get().length());
        System.gc();//内存不紧张,s2不会被回收
        System.out.println("after manual gc:" + s2.get().length());
        //启动heap内存为5m,上面list用掉一部分且为软引用,
        //再申请分配3m的内存,软引用对象会在内存紧张时被回收,内存分配成功
        byte[] bytes = new byte[1024*1024*3];
        System.out.println("after system gc:" + (s2.get()==null));
        System.out.println("malloc 3m heap success");
    }
}
