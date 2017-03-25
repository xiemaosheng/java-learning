package com.brianway.learning.java.xms.synchronize.test;

import com.brianway.learning.java.xms.synchronize.service.MyObject;
import com.brianway.learning.java.xms.synchronize.service.MyThread08;
import com.brianway.learning.java.xms.synchronize.service.MyThread09;
import com.brianway.learning.java.xms.synchronize.service.Service;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class TestRun05 {
    public static void main(String[] args) throws Exception{
        /**
         * 1 当其他线程 执行myObject对象中的synchronized 同步方法时呈现同步效果
         * 2 当其他线程 执行MyObject对象方法中synchronized（this）代码块也呈现同步效果
         */
        Service service = new Service();
        MyObject myObject = new MyObject();
        MyThread08 myThread08 = new MyThread08(myObject,service);

        myThread08.setName("myThread08");
        myThread08.start();

//        Thread.sleep(1000);

        MyThread09 myThread09 = new MyThread09(myObject);
        myThread09.setName("MyThread09");
        myThread09.start();

    }
}
