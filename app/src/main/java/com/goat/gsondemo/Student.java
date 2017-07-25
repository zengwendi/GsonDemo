package com.goat.gsondemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zengwendi on 2017/7/11.
 */

public class Student {
    @SerializedName("names")
    private String name;
    private int age;
    @SerializedName(value = "score",alternate ={"chinese","math","english"})
    private String score;

    public Student(String name, int age, String score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score='" + score + '\'' +
                '}';
    }
}
