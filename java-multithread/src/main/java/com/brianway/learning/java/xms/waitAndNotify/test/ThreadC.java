package com.brianway.learning.java.xms.waitAndNotify.test;

import com.brianway.learning.java.xms.waitAndNotify.Customer;

/**
 * Created by Administrator on 2017/4/2 0002.
 */
public class ThreadC extends Thread {
    private Customer customer;

    public ThreadC(Customer customer){
        this.customer = customer;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            customer.getValue();
        }
    }
}
