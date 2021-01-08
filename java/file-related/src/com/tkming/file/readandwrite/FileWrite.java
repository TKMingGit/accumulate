package com.tkming.file.readandwrite;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/25 9:51
 * @desc 暂无
 */
public class FileWrite {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/tempSs/a.txt"), "utf-8"))) {
            bw.write("张三QER谔谔ccfasd的风格十分！@#！@%￥%#@……%￥@");
            bw.newLine();
            bw.write("sdfasdfasdfasdfas");
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
