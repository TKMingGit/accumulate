package com.otg.kafka.entity;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/2/5 15:30
 * @desc 暂无
 */
public class Student {
    public String name;
    public int age;
    public boolean sex;

    public Student() {
    }

    public Student(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
