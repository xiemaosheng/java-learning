package com.brianway.learning.java.base.cache.test;

import com.brianway.learning.java.base.cache.model.User;
import com.brianway.learning.java.base.cache.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class Test01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        UserService userService = context.getBean("userService",UserService.class);
        UserService userService1 = context.getBean("userService",UserService.class);
        UserService userService2 = context.getBean("userService",UserService.class);
        System.out.println("service bean:" + userService);

        userService.add(new User("1","xms1","111"));
        userService.add(new User("2","xms2","222"));
        userService.add(new User("3","xms3","333"));

        System.out.println(userService.find("2").getUsername());

        System.out.println(userService2.find("2").getUsername());

        System.out.println(userService.find("1").getUsername());

        System.out.println(userService2.find("1").getUsername());

        Map<String,User> map = userService.getAll();
        for (Map.Entry<String,User> entry : map.entrySet()){
            System.out.println(entry.getValue().getUsername());
        }

        Map<String,User> map1 = userService1.getAll();
        for (Map.Entry<String,User> entry : map1.entrySet()){
            System.out.println(entry.getValue().getUsername());
        }

        userService2.update(new User("1","xxx","1xx"));
        userService2.update(new User("2","222","222222"));

        System.out.println(userService2.find("1").getUsername());
        System.out.println(userService2.find("2").getUsername());
        System.out.println(userService2.findTest("1").getUsername());
        System.out.println(userService2.findTest("1").getUsername());
        System.out.println(userService2.find("1").getUsername());
        System.out.println(userService2.find("2").getUsername());
        Map<String,User> map3 = userService2.getAll();
        for (Map.Entry<String,User> entry : map3.entrySet()){
            System.out.println(entry.getValue().getUsername());
        }
    }
}
