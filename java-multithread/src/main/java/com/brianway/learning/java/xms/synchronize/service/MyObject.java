package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class MyObject {
    synchronized public void speedPrintString(){
        System.out.println("speedPrintString __getLock time=" + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread().getName());
        System.out.println("------------------------------");
        System.out.println("speedPrintString releaseLock time=" + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread().getName());
    }
}
