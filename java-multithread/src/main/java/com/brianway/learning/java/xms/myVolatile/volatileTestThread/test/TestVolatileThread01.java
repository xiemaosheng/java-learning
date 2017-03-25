package com.brianway.learning.java.xms.myVolatile.volatileTestThread.test;

import com.brianway.learning.java.xms.myVolatile.volatileTestThread.VolatileThread01;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class TestVolatileThread01 {
    public static void main(String[] args) {
        /**
         * i++ 非原子操作
         */
        VolatileThread01[] volatileThread01 = new VolatileThread01[100];
        for (int i=0;i<100;i++){
            volatileThread01[i] = new VolatileThread01();
        }
        for (int i =0;i<100;i++){
            volatileThread01[i].start();
        }
    }
}
