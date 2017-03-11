package com.brianway.learning.java.base.cache.test;

import com.brianway.learning.java.base.cache.model.User;
import com.brianway.learning.java.base.cache.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class Test03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        UserService userService = context.getBean("userService",UserService.class);
        System.out.println("service bean:" + userService);

        userService.add(new User("1","xms1","111"));
        userService.add(new User("2","xms2","222"));
        userService.add(new User("3","xms3","333"));

        System.out.println(userService.find("1").getUsername());
        System.out.println(userService.find("1").getUsername());

        userService.update(new User("1","xms111111","111111111"));
        System.out.println(userService.findTest("1").getUsername());
        System.out.println(userService.find("1").getUsername());


    }
}
