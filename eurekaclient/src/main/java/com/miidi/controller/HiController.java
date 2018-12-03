package com.miidi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/7/26.
 */
@Slf4j
@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    @GetMapping("/hi/{name}" )
    public String home (@PathVariable("name") String name) {
        return "hi"+name+", I am from port : " +port;
    }

    @GetMapping("/user/{age}")
    public User getUser(@PathVariable("age") Integer age){
        User user;
        if(age == 1){
            user = new User("andy,port:"+port,1);
        }else{
            user = new User("junxi,port:"+port,5);
        }
        return user;
    }

    @PostMapping("/user")
    public User user(User user){
        log.error("client user:{}",user);
        return user;
    }
}