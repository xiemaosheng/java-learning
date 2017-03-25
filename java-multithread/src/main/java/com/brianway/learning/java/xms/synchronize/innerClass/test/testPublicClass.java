package com.brianway.learning.java.xms.synchronize.innerClass.test;

import com.brianway.learning.java.xms.synchronize.innerClass.PublicClass;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class testPublicClass {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("xms");
        publicClass.setPassword("123456");

        System.out.println(publicClass.getUsername() + " " + publicClass.getPassword() );

        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();

        privateClass.setAge("20");
        privateClass.setAddress("hunan");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress() );
    }
}
