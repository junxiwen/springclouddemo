package com.miidi.service;

import com.miidi.controller.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/26.
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;


    //@Override
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHello(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi/"+name,String.class);
    }


    public User user(User user){
        User resUser =  restTemplate.postForObject("http://EUREKA-CLIENT/user", user, User.class);
        return resUser;
    }


    @HystrixCommand(fallbackMethod = "errorRes")
    public User getUser(Integer age){
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://EUREKA-CLIENT/user/" + age, User.class);
        return responseEntity.getBody();
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }


    public User errorRes(Integer age){
        User user = new User("error",age);
        return user;
    }
}
