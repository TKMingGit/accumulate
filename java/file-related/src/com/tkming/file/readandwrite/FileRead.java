package com.tkming.file.readandwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/25 9:51
 * @desc 暂无
 */
public class FileRead {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/tempSs/a.txt"), "utf-8"))) {
            String aa;
            while ((aa = br.readLine()) != null) {
                System.out.println(aa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}