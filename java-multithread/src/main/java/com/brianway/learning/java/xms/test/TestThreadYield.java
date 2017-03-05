package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadYield;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadYield {
    public static void main(String[] args) {
        ThreadYield threadYield = new ThreadYield();
        threadYield.start();
    }
}
