package com.tkming.spring.aop.cglib;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/4/23
 * @description Cglib 不但可以对接口进行代理，也可以对目标类对象，实现代理（解决了 Jdk 只能对接口代理问题 ）。
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        /*ProductDao productDao = new ProductDao();
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(productDao);
        ProductDao proxy =  (ProductDao) cglibProxyFactory.createProxy();
        proxy.save();*/

        ProductDao productDao = new ProductDao();
        ProductDao productDaoProxy = (ProductDao) new CglibProxyFactory(productDao).createProxy();
        productDaoProxy.save();

    }
}
