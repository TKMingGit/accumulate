package com.tkming.spring.aop.jdkproxy;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/4/23
 * @description 使用Jdk动态代理，必须要求target目标对象，实现接口 ，如果没有接口，不能使用Jdk动态代理
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(userService);
        UserService proxy = (UserService) jdkProxyFactory.createProxy();
        proxy.save();
    }
}
