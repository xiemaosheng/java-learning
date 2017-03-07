package com.brianway.learning.java.base.reflect.spring_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/6 0006.
 */
@Aspect
@Component
public class GreetingAspect {

    @Around("execution(com.brianway.learning.java.base.reflect.hello.HelloImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    @After("@annotation(com.brianway.learning.java.base.reflect.spring_aop.Tag)")
    public Object test(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();
        after();
        return result;
    }
}
