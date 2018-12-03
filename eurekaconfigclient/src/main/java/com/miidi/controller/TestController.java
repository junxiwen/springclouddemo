package com.miidi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/30.
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${form}")
    private String form;

    @GetMapping("/form")
    public String getFrom(){
        return this.form;
    }
}
