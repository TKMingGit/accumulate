package com.tkming.clone.shallow;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/24
 * @description
 */
public class Mark {
    String Chinese;
    String english;
    String math;

    public Mark() {
    }

    public Mark(String chinese, String english, String math) {
        Chinese = chinese;
        this.english = english;
        this.math = math;
    }

    public String getChinese() {
        return Chinese;
    }

    public void setChinese(String chinese) {
        Chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "Chinese='" + Chinese + '\'' +
                ", english='" + english + '\'' +
                ", math='" + math + '\'' +
                '}';
    }
}
