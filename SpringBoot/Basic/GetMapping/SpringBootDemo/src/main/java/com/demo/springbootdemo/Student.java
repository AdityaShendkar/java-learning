package com.demo.springbootdemo;

public class Student {
    int id;
    String name;
    float per;

    public Student() {
    }

    public Student(int id, String name, float per) {
        this.id = id;
        this.name = name;
        this.per = per;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPer() {
        return per;
    }

    public void setPer(float per) {
        this.per = per;
    }
}
