package com.tkming.file;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/25 16:32
 * @desc 暂无
 */
public class Cat extends Animal implements Comparable {
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Animal a1 = this;
        Animal a2 = (Animal)o;
        a1.mage = cat[a1.age];
        a2.mage = cat[a2.age];
        return (a1.mage - a2.mage);
    }
}
