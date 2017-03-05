package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadPriority01;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadPriority01 {
    public static void main(String[] args) {
        System.out.println("main thread priority = " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread priority = " + Thread.currentThread().getPriority());
        ThreadPriority01 priority01 = new ThreadPriority01();
        priority01.start();
    }
}
