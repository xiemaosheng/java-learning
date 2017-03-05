package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.Thread09;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThread09 {
    public static void main(String[] args) {
        Thread09 thread09 = new Thread09();
        System.out.println("begin = " + System.currentTimeMillis());
        thread09.start();
        System.out.println("end = " + System.currentTimeMillis());
    }
}
