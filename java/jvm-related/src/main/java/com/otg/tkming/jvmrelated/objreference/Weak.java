package com.otg.tkming.jvmrelated.objreference;

import java.lang.ref.WeakReference;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/28 15:48
 * @desc 弱引用,-Xmx5m
 */
public class Weak {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            s1.append("0000000000");
        }
        WeakReference<StringBuilder> s2 = new WeakReference<>(s1);
        s1 = null;
        System.out.println("before manual gc:" + s2.get().length());
        System.gc();//遇到gc,弱引用s2会被回收
        System.out.println("after manual gc:" + (s2.get()==null));
        //再申请分配3m的内存,内存分配成功
        byte[] bytes = new byte[1024*1024*3];
        System.out.println("malloc 3m heap success");
    }
}
