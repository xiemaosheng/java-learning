package com.brianway.learning.java.xms.test;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadGetId {
    public static void main(String[] args) {
        Thread runThread = Thread.currentThread();
        System.out.println(runThread.getName() + " " + runThread.getId());
    }
}
