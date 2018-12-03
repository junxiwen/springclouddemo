package com.miidi.service;

import com.miidi.controller.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2018/7/26.
 */
//指定要调用的服务名
@FeignClient(value = "EUREKA-CLIENT")
public interface FeignService {
    @GetMapping("/hi/{name}")
    String sayHi(@PathVariable("name") String name);


    @GetMapping("/user/{age}")
    User getUser(@PathVariable("age") Integer age);
}
