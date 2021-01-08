package main.java.com.otg.proxy.dynamic;

import main.java.com.otg.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/11/25 14:47
 * @desc 暂无
 */
public class ProxyHandler implements InvocationHandler {
    private Subject subject;
    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println("===========before===========");
        Object result = method.invoke(subject, args);
        System.out.println("===========after===========");
        return result;
    }
}
