package com.miidi.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/7/26.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/{name}")
    @ApiOperation(value="用户列表1", notes=" 用户列表2")
    public String testGet(@PathVariable("name")String name){
        return "hello,"+name;
    }



    @GetMapping
    @ApiOperation(value="百度", notes="请求百度")
    public String list(){
        RestTemplate restTemplate=new RestTemplate() ;
        return restTemplate.getForObject("https://www.baidu.com", String.class) ;
    }
}
