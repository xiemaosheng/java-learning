package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.Thread06;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThread06 {
    public static void main(String[] args) throws Exception{
        Thread06 thread06 = new Thread06();
        System.out.println("begin == " + thread06.isAlive());
        thread06.start();
        thread06.sleep(1000l);
        System.out.println("end == " + thread06.isAlive());
    }
}
