package com.tkming.clone.shallow;

import com.tkming.clone.shallow.Mark;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/24
 * @description
 */
public class Student implements Cloneable{
    String name;
    Integer age;
    Mark mark;

    public Student() {
    }

    public Student(String name, Integer age, Mark mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
