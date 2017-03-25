package com.brianway.learning.java.xms.synchronize.setNewStringTwoLock;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class MyService {
    private String lock= "123";
    public void testMethod(){
        try {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                lock = "456";
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
