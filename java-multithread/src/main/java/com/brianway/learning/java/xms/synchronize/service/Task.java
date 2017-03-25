package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class Task {
    public void otherMethod(){
        System.out.println("--------------------------------------- run --- otherMethod:");
    }

    public void serviceMethod(){
        synchronized (this){
            for (int i =0; i < 1000;i++){
                System.out.println("synchroized threadName=" + Thread.currentThread().getName() + " i=" + (i+1));
            }
        }
    }

    public synchronized void test(){
        System.out.println("--------------------------------------- run --- test:");
    }
}
