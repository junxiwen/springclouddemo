package com.miidi.service;

import com.miidi.controller.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/26.
 */
@Service
public class HiServiceImpl implements HiService {

    @Autowired(required = false)
    private FeignService feignService;

    @Override
    public String hi(String name) {
        return feignService.sayHi(name);
    }

    @Override
    public User getUser(Integer age) {
        return feignService.getUser(age);
    }
}
