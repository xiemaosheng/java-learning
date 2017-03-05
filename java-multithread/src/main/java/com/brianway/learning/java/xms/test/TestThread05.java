package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.Thread05;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThread05 {
    public static void main(String[] args) {
        Thread05 thread05 = new Thread05();
        Thread t = new Thread(thread05);
        t.setName("A");
        t.start();
    }
}
