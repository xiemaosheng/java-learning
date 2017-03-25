package com.brianway.learning.java.xms.synchronize.innerClass.test;

import com.brianway.learning.java.xms.synchronize.innerClass.PublicInnerStaticClass;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class testPublicInnerStaticClass {
    public static void main(String[] args) {
        PublicInnerStaticClass publicClass = new PublicInnerStaticClass();
        publicClass.setUsername("xms");
        publicClass.setPassword("123456");

        System.out.println(publicClass.getUsername() + " " + publicClass.getPassword() );

        PublicInnerStaticClass.PrivateClass privateClass = new PublicInnerStaticClass.PrivateClass();

        privateClass.setAge("20");
        privateClass.setAddress("hunan");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress() );
    }
}
