package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadInterrupt08;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadInterrupt08 {
    public static void main(String[] args) {
        try {
            ThreadInterrupt08 interrupt08 = new ThreadInterrupt08();
            interrupt08.start();
            Thread.sleep(2000);
            interrupt08.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
