package com.tkming.clone.deep;

import java.io.Serializable;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/24
 * @description
 */
public class GradeSer implements Serializable {
    private static final long serialVersionUID = -1016794828527764101L;

    String level;
    String subject;

    public GradeSer() {
    }

    public GradeSer(String level, String subject) {
        this.level = level;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "GradeSer{" +
                "level='" + level + '\'' +
                ", subject='" + subject + '\'' +
                '}';
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
