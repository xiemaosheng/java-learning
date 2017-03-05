package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.MyThread01;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class Test01 {
    public static void main(String args[]){
        MyThread01 myThread01 = new MyThread01(1);
        MyThread01 myThread02 = new MyThread01(2);
        MyThread01 myThread03 = new MyThread01(3);
        MyThread01 myThread04 = new MyThread01(4);
        MyThread01 myThread05 = new MyThread01(5);
        MyThread01 myThread06 = new MyThread01(6);
        myThread01.start();
        myThread02.start();
        myThread03.start();
        myThread04.start();
        myThread05.start();
        myThread06.start();
        System.out.println(Thread.currentThread().getName());
        myThread01.run();
    }
}
