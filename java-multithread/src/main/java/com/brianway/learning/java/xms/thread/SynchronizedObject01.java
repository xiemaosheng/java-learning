package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class SynchronizedObject01 {
    synchronized public void printString(){
        System.out.println("begin:");
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("a 线程永远 suspend 了");
            Thread.currentThread().suspend();
        }
        System.out.println("end:");
    }
}
