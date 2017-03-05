package com.brianway.learning.java.base.reflect.hello;

/**
 * Created by xms on 2017/3/5 0005.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("hello:" + name);
    }
}
