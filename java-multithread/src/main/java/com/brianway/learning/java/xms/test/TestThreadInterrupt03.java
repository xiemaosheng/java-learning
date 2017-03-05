package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadInterrupt03;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadInterrupt03 {
    public static void main(String[] args) {
        try {
            ThreadInterrupt03 interrupt03 = new ThreadInterrupt03();
            interrupt03.start();
            Thread.sleep(200);
            interrupt03.interrupt();
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();

        }

        System.out.println("end!");
    }
}
