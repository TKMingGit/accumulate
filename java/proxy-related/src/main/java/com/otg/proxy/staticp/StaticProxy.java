package main.java.com.otg.proxy.staticp;

import main.java.com.otg.proxy.Subject;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/11/25 14:07
 * @desc 暂无
 */
public class StaticProxy implements Subject {
    Subject subject = null;

    public StaticProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("pre process");
        subject.request();
        System.out.println("post process");
    }
}
