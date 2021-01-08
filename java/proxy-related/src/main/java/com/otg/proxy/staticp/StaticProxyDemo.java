package main.java.com.otg.proxy.staticp;

import main.java.com.otg.proxy.Subject;
import main.java.com.otg.proxy.SubjectImpl;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/11/25 14:08
 * @desc 暂无
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        StaticProxy staticProxy = new StaticProxy(subject);
        staticProxy.request();
    }
}
