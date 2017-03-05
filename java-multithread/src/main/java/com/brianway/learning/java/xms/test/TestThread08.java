package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.Thread08;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThread08 {
    public static void main(String[] args) {
        Thread08 thread08 = new Thread08();
        System.out.println("begin = " + System.currentTimeMillis());
        thread08.run();
        System.out.println("end = " + System.currentTimeMillis());
    }
}
