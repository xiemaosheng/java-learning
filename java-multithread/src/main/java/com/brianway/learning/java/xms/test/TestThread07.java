package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.Thread07;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThread07 {
    public static void main(String[] args) {
        Thread07 thread07 = new Thread07();
        Thread t = new Thread(thread07);
        System.out.println("main begin t isAlive = " + t.isAlive());
        t.setName("a");
        t.start();
        System.out.println("main end t isAlive = " + t.isAlive());
    }
}
