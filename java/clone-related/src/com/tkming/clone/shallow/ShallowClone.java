package com.tkming.clone.shallow;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/24
 * @description 浅克隆就是引用类型的属性无法完全复制
 */
public class ShallowClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mark mark = new Mark("98.5", "97.5", "100");
        Student bob = new Student("bob", 20, mark);
        Student bobClone = (Student) bob.clone();
        bobClone.setName("bobClone");
        bobClone.setAge(30);
        bobClone.getMark().setChinese("88.5");
        bobClone.getMark().setEnglish("87.5");
        bobClone.getMark().setMath("90");
        System.out.println(bob);
        System.out.println(bobClone);
    }
}
