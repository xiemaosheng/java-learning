package com.brianway.learning.java.base.classLoader.serviceLoader.impl;

import com.brianway.learning.java.base.classLoader.serviceLoader.IService;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
public class LocalServiceImpl implements IService {
    @Override
    public String sayHello() {
        return "hello LocalService";
    }

    @Override
    public String getScheme() {
        return "local";
    }
}
