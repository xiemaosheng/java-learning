package com.brianway.learning.java.xms.waitAndNotify.test;

import com.brianway.learning.java.xms.waitAndNotify.Product;

/**
 * Created by Administrator on 2017/4/2 0002.
 */
public class ThreadP extends Thread {
    private Product product;

    public ThreadP(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            product.setValue();
        }
    }
}
