package com.brianway.learning.java.xms.waitAndNotify;

import com.brianway.learning.java.multithread.communication.example8.ValueObject;

/**
 * Created by Administrator on 2017/4/2 0002.
 */
public class Product {
    private String lock;

    public Product(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock){
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" +System.nanoTime();

                System.out.println("set 的值是：" + value);

                ValueObject.value = value;
                lock.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
