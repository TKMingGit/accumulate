package com.tkming.file;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/25 16:32
 * @desc 暂无
 */
public class Dog extends Animal implements Comparable {
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Object o) {
        Animal a1 = this;
        Animal a2 = (Animal)o;
        a1.mage = dog[a1.age];
        a2.mage = dog[a2.age];
        return (a1.mage - a2.mage);
    }
}
