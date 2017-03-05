package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadInterrupt05;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadInterrupt05 {
    public static void main(String[] args) {
        try {
            ThreadInterrupt05 interrupt05 = new ThreadInterrupt05();
            interrupt05.start();
            Thread.sleep(8000);
            interrupt05.stop();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
