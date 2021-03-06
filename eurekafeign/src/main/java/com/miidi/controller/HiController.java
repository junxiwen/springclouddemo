package com.miidi.controller;

import com.miidi.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/26.
 */
@Slf4j
@RestController
public class HiController {
    @Autowired
    private IUserService userService;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name")String name){
        log.error("feign接收请求");
        return userService.sayHi(name);
    }


    @GetMapping(value = "/user/{age}")
    public User getUser(@PathVariable("age") Integer age){
        return userService.getUser(age);
    }
}
