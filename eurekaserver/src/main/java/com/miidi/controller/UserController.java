package com.miidi.controller;

import com.miidi.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping
    public List<User> getUserList(User user){
        List<User> userList = new ArrayList<>();
        System.out.println(user);
        user = new User("jx","wen");
        userList.add(user);
        return userList;
    }
}
