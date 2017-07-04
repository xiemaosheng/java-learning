package com.brianway.learning.java.base.classLoader.serviceLoader.impl;

import com.brianway.learning.java.base.classLoader.serviceLoader.IService;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
public class HDFSServiceImpl implements IService {
    @Override
    public String sayHello() {
        return "hello HDFSService";
    }

    @Override
    public String getScheme() {
        return "hdfs";
    }
}
