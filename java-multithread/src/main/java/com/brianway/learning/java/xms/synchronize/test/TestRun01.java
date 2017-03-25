package com.brianway.learning.java.xms.synchronize.test;

import com.brianway.learning.java.xms.synchronize.service.MyThread01;
import com.brianway.learning.java.xms.synchronize.service.MyThread02;
import com.brianway.learning.java.xms.synchronize.service.ObjectService;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class TestRun01 {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        MyThread01 thread01 = new MyThread01(service);
        thread01.setName("a");
        thread01.start();

        MyThread02 thread02 = new MyThread02(service);
        thread02.setName("b");
        thread02.start();
    }
}
