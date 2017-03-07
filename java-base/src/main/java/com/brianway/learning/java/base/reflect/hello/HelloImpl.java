package com.brianway.learning.java.base.reflect.hello;

import com.brianway.learning.java.base.reflect.spring_aop.Tag;

/**
 * Created by xms on 2017/3/5 0005.
 */
public class HelloImpl implements Hello {
    @Tag
    @Override
    public void say(String name) {
        System.out.println("hello:" + name);
    }
}
