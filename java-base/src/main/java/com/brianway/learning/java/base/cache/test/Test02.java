package com.brianway.learning.java.base.cache.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.brianway.learning.java.base.cache.model.User;
import com.brianway.learning.java.base.cache.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class Test02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        UserService userService = context.getBean("userService",UserService.class);
        System.out.println("service bean:" + userService);

        User user = new User("1","xms","1111");
        String arr = "[491036508016,491036501742,491036503365]";
        String arr2 = "[491036503365,491036501742,491036508016]";

        List<String> nodes = new ArrayList<>();
        nodes.add("491036508016");
        nodes.add("491036501742");
        nodes.add("491036503365");
        nodes.add("12314214124124");
        nodes.add("21431414124114");

        List<String> list = new ArrayList<>();
        list.add("491036501742");
        list.add("491036508016");
        list.add("491036503365");
        list.add("21431414124114");
        list.add("12314214124124");

        String arr3 = JSONObject.toJSONString(nodes);
        System.out.println(arr3);
        String arr4 = JSONObject.toJSONString(list);
        System.out.println(arr4);

        JSONArray jsonArray = JSONArray.parseArray(arr);
        JSONArray jsonArray2 = JSONArray.parseArray(arr2);
        JSONArray jsonArray3 = JSONArray.parseArray(arr3);
        JSONArray jsonArray4 = JSONArray.parseArray(arr4);



        System.out.println(userService.test(user.getId(),jsonArray));
        System.out.println(userService.test(user.getId(),jsonArray));
        System.out.println(userService.test(user.getId(),jsonArray2));
        System.out.println(userService.test(user.getId(),jsonArray3));
        System.out.println(userService.test(user.getId(),jsonArray4));
        System.out.println(userService.test("2",jsonArray));
    }
}
