package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadInterrupt02;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadInterrupt02 {
    public static void main(String[] args) {
        try {
            ThreadInterrupt02 interrupt02 = new ThreadInterrupt02();
            interrupt02.start();
            Thread.sleep(2000);
            interrupt02.interrupt();
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end !");
    }
}
