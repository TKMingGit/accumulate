package com.tkming.clone.deep;

import java.io.Serializable;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/24
 * @description
 */
public class TeacherSer implements Serializable {
    String name;
    String sex;
    GradeSer gradeSer;

    public TeacherSer() {
    }

    public TeacherSer(String name, String sex, GradeSer gradeSer) {
        this.name = name;
        this.sex = sex;
        this.gradeSer = gradeSer;
    }

    @Override
    public String toString() {
        return "TeacherSer{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", gradeSer=" + gradeSer +
                '}';
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

    public GradeSer getGradeSer() {
        return gradeSer;
    }

    public void setGradeSer(GradeSer gradeSer) {
        this.gradeSer = gradeSer;
    }
}
