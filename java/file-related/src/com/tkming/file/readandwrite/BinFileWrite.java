package com.tkming.file.readandwrite;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/25 10:52
 * @desc 暂无
 */
public class BinFileWrite {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("d:/tempSs/b.dat")))) {
            dos.writeUTF("a");
            dos.writeInt(20);
            dos.writeInt(180);
            dos.writeUTF("b");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
