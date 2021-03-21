package com.itcast.springboot.model;


import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private String phone;
    private String address;

}
