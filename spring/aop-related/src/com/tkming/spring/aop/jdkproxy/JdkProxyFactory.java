package com.tkming.spring.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/4/23
 * @description
 */
public class JdkProxyFactory {
    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object createProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //运行增强的方法
                System.out.println("method enhance");
                //运行被代理对象的真正方法
                return method.invoke(target, args);
            }
        });
    }
}
