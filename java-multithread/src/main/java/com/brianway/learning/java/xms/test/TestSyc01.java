package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.SynchronizedObject01;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestSyc01 {
    public static void main(String[] args) {
        try {
            final SynchronizedObject01 object01 = new SynchronizedObject01();
            Thread thread = new Thread(){
                @Override
                public void run() {
                    object01.printString();
                }
            };
            thread.setName("a");
            thread.start();
            thread.sleep(1000);

            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    System.out.println("thread1启动了，但进入不了printString 方法！,只是打印出begin");
                    System.out.println("因为 printString()方法被a线程锁定并且永远suspend暂停");
                    object01.printString();
                }
            };
            thread1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
