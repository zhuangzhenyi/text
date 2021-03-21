package com.itcast.springboot.model;


import java.io.Serializable;

public class Student implements Serializable {//本地对象在网络中传输需要序列化

    private Integer id;

    private String stuName;

    private Integer stuAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

}