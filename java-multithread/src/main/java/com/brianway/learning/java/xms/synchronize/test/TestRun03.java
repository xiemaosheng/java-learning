package com.brianway.learning.java.xms.synchronize.test;

import com.brianway.learning.java.xms.synchronize.service.MyThread06;
import com.brianway.learning.java.xms.synchronize.service.MyThread07;
import com.brianway.learning.java.xms.synchronize.service.ObjectService01;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class TestRun03 {
    public static void main(String[] args) {
        /**
         * 使用同一对象监视器
         */
        ObjectService01 service = new ObjectService01();
        Object object = new Object();
        MyThread06 thread01 = new MyThread06(service,object);
        thread01.setName("a");
        thread01.start();

        MyThread07 thread02 = new MyThread07(service,object);
        thread02.setName("b");
        thread02.start();
    }
}
