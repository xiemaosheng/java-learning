package com.brianway.learning.java.base.cache.test;

import com.brianway.learning.java.base.cache.model.User;
import com.brianway.learning.java.base.cache.service.UserService;
import com.brianway.learning.java.base.cache.service.UserService01;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class Test04 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        UserService01 userService01 = context.getBean("userService01",UserService01.class);
        System.out.println("service bean:" + userService01);

        userService01.add(new User("1","xms1","111"));
        userService01.add(new User("2","xms2","222"));
        userService01.add(new User("3","xms3","333"));

        System.out.println(userService01.find("1").getUsername());
        System.out.println(userService01.find("1").getUsername());

        userService01.update(new User("1","xms111111","111111111"));
        System.out.println(userService01.findTest("1").getUsername());
        System.out.println(userService01.find("1").getUsername());


    }
}
