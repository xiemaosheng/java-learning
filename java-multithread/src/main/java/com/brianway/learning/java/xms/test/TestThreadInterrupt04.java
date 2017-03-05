package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadInterrupt04;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadInterrupt04 {
    public static void main(String[] args) {
        ThreadInterrupt04 interrupt04 = new ThreadInterrupt04();
        interrupt04.start();
        interrupt04.interrupt();
        System.out.println("end!");
    }
}
