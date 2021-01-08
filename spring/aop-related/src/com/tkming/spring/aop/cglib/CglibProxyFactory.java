package com.tkming.spring.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/4/23
 * @description
 */
public class CglibProxyFactory implements MethodInterceptor {
     /** 被代理目标对象*/
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    /** 创建代理对象方法*/
    public Object createProxy() {
        // 1、 创建Enhancer对象
        Enhancer enhancer = new Enhancer();

        // 2、 cglib创建代理，对目标对象，创建子类对象
        enhancer.setSuperclass(target.getClass());

        // 3、传入 callback对象，对目标增强
        enhancer.setCallback(this);

        return enhancer.create();
    }

    /**
     * proxy 代理对象
     * method 当前调用方法
     * args 方法参数
     * methodProxy 被调用方法代理对象 （作用：执行父类的方法）
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("method enhance");
        // 按照JDK编程
        // return method.invoke(target, objects);
        return methodProxy.invokeSuper(o, objects);
    }
}
