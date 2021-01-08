package com.tkming.file.readandwrite;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/25 10:52
 * @desc 暂无
 */
public class BinFileRead {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("d:/tempSs/b.dat")))) {
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
