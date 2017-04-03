package com.brianway.learning.java.xms.waitAndNotify;

import com.brianway.learning.java.multithread.communication.example8.ValueObject;

/**
 * Created by Administrator on 2017/4/2 0002.
 */
public class Customer {
    private String lock;

    public Customer(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock){
                if (ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("get 的值是"+ ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
