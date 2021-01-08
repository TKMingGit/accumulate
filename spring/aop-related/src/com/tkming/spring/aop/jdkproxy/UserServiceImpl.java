package com.tkming.spring.aop.jdkproxy;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/4/23
 * @description
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save operation.");
    }
}
