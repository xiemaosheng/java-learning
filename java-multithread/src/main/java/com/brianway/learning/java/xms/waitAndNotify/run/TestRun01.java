package com.brianway.learning.java.xms.waitAndNotify.run;

import com.brianway.learning.java.xms.waitAndNotify.Customer;
import com.brianway.learning.java.xms.waitAndNotify.Product;
import com.brianway.learning.java.xms.waitAndNotify.test.ThreadC;
import com.brianway.learning.java.xms.waitAndNotify.test.ThreadP;

/**
 * Created by Administrator on 2017/4/2 0002.
 */
public class TestRun01 {
    public static void main(String[] args) {
        String lock = new String("");
        Product product = new Product(lock);
        Customer customer = new Customer(lock);

        ThreadP threadP = new ThreadP(product);
        ThreadC threadC = new ThreadC(customer);

        threadP.start();
        threadC.start();
    }
}
