package com.tkming.clone.deep;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/24
 * @description
 */
public class Teacher implements Cloneable {
    String name;
    String sex;
    Grade grade;

    public Teacher() {
    }

    public Teacher(String name, String sex, Grade grade) {
        this.name = name;
        this.sex = sex;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Teacher teacher = (Teacher) super.clone();
        teacher.grade = (Grade) this.grade.clone();
        return teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
