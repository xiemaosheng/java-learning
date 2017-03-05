package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadInterrupt;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadInterrupt {
    public static void main(String[] args) {
        try {
            ThreadInterrupt interrupt = new ThreadInterrupt();
            interrupt.start();
            interrupt.sleep(5000);
            interrupt.interrupt();
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
