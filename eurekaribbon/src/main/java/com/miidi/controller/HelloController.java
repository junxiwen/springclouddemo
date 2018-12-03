package com.miidi.controller;

import com.miidi.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/18.
 */
@Slf4j
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hi/{name}")
    public String hi(@PathVariable("name") String name) {
        log.error("ribbon接收请求");
        return helloService.sayHello( name );
    }

    @GetMapping(value = "/user/{age}")
    public User getUser(@PathVariable("age") Integer age){
        return helloService.getUser(age);
    }


    @GetMapping(value = "/user")
    public User getUser(User user){
        log.error("ribbon user:{}",user);
        return helloService.user(user);
    }
    /*@GetMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance choose = loadBalancerClient.choose("EUREKA-CLIENT");
        return choose.getHost()+":"+choose.getPort();
    }*/
}