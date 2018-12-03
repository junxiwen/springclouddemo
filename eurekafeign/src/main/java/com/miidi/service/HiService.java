package com.miidi.service;

import com.miidi.controller.User;

/**
 * Created by Administrator on 2018/7/26.
 */
public interface HiService {
    String hi(String name);


    User getUser(Integer age);
}
