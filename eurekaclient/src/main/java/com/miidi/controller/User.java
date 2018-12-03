package com.miidi.controller;

import lombok.Data;

/**
 * Created by Administrator on 2018/10/29.
 */
@Data
public class User {
    private String userName;
    private Integer age;
    public User(){}

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }
}
