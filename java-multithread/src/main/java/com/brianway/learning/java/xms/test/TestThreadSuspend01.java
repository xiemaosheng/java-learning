package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadSuspend01;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadSuspend01 {
    public static void main(String[] args) {
        try {
            ThreadSuspend01 suspend01 = new ThreadSuspend01();
            suspend01.start();
            Thread.sleep(5000);
            suspend01.suspend();
            System.out.println("A= " + System.currentTimeMillis() + " i = " + suspend01.getId());
            Thread.sleep(5000);
            System.out.println("A= " + System.currentTimeMillis() + " i = " + suspend01.getId());

            suspend01.resume();
            Thread.sleep(5000);

            suspend01.suspend();
            System.out.println("C= " + System.currentTimeMillis() + " i = " + suspend01.getId());
            Thread.sleep(5000);
            System.out.println("C= " + System.currentTimeMillis() + " i = " + suspend01.getId());

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
