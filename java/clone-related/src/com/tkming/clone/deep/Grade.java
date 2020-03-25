package com.tkming.clone.deep;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/24
 * @description
 */
public class Grade implements Cloneable{
    String level;
    String subject;

    public Grade() {
    }

    public Grade(String level, String subject) {
        this.level = level;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "level='" + level + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
