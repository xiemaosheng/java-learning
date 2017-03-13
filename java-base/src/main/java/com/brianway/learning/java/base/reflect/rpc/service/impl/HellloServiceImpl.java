package com.brianway.learning.java.base.reflect.rpc.service.impl;

import com.brianway.learning.java.base.reflect.rpc.service.HelloService;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public class HellloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "hello:" + name;
    }
}
