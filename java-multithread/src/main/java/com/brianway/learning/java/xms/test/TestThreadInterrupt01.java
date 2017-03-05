package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadInterrupt01;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadInterrupt01 {
    public static void main(String[] args) {
        try {
            ThreadInterrupt01 interrupt01 = new ThreadInterrupt01();
            interrupt01.start();
            Thread.sleep(500);
            interrupt01.interrupt();
//            Thread.currentThread().interrupt();// 暂停当前线程
            System.out.println("is stop1 :" + interrupt01.isInterrupted()); // 测试当前线程是否暂停
            System.out.println("is stop2 :" + interrupt01.isInterrupted());
//            System.out.println("is stop1 :" + Thread.interrupted());
//            System.out.println("is stop2 :" + Thread.interrupted());
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end !");


    }
}
