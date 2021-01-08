package main.java.com.otg.proxy;

import main.java.com.otg.proxy.Subject;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/11/25 14:06
 * @desc 暂无
 */
public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("request");
    }
}
