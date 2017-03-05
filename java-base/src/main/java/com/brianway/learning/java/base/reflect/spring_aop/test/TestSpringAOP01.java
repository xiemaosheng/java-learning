package com.brianway.learning.java.base.reflect.spring_aop.test;

import com.brianway.learning.java.base.reflect.hello.Hello;
import com.brianway.learning.java.base.reflect.hello.HelloImpl;
import com.brianway.learning.java.base.reflect.spring_aop.HelloAfterAdvice;
import com.brianway.learning.java.base.reflect.spring_aop.HelloBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class TestSpringAOP01 {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new HelloImpl());
        proxyFactory.addAdvice(new HelloBeforeAdvice());
        proxyFactory.addAdvice(new HelloAfterAdvice());

        Hello hello = (Hello) proxyFactory.getProxy();
        hello.say("xms");
    }
}
