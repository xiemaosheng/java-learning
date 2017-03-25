package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class ObjectService01 {
    public void testMethod1(Object object) {
        synchronized (object) {
            try {
                System.out.println("testMethod1 __getLock Time = " +
                                   System.currentTimeMillis() + " run ThreadName=" +
                                   Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock time=" +
                                  System.currentTimeMillis() + " run ThreadName=" +
                                  Thread.currentThread().getName());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
