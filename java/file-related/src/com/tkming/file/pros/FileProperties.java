package com.tkming.file.pros;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/24 16:19
 * @desc 暂无
 */
public class FileProperties {
    public static void main(String[] args) throws IOException {
        File d = new File("d:/tempSs");
        if (!d.exists()) {
            d.mkdir();
        }
        System.out.println("d is directory ? " + d.isDirectory());
        File f = new File("d:/tempSs/aa.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        System.out.println("f is file? " + f.isFile());
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.getPath());
        System.out.println(f.length());
        System.out.println(f.lastModified());

        File[] files = d.listFiles();
        for (File file : files) {
            System.out.println(file.getPath());
        }
//        f.delete();
//        d.delete();
    }
}
