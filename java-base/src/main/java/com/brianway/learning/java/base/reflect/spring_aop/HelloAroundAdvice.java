package com.brianway.learning.java.base.reflect.spring_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class HelloAroundAdvice implements MethodInterceptor {

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("after");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }
}
