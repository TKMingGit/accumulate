package com.otg.reflect.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/11/25 10:53
 * @desc 暂无
 */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InterruptedException, InstantiationException {
        String content = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/conf.txt"))) {
            content = bufferedReader.readLine();
            System.out.println("content:" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] params = content.split(",");
        Object o = Class.forName("com.otg.reflect.test1." + params[0]).newInstance();
        Method m = Class.forName("com.otg.reflect.test1." + params[0]).getMethod(params[1]);
        while (true) {
            m.invoke(o);
            Thread.sleep(Integer.valueOf(params[2]) * 1000);
        }
    }
}
