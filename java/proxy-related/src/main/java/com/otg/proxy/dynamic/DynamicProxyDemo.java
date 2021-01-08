package main.java.com.otg.proxy.dynamic;

import main.java.com.otg.proxy.Subject;
import main.java.com.otg.proxy.SubjectImpl;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/11/25 14:52
 * @desc 暂无
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        ProxyHandler handler = new ProxyHandler(subject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(SubjectImpl.class.getClassLoader(), SubjectImpl.class.getInterfaces(), handler);
        proxySubject.request();
        System.out.println(proxySubject.getClass().getName());
    }
}
