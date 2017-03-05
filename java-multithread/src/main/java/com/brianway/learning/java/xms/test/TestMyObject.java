package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.MyObject;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestMyObject {
    public static void main(String[] args) {
        try {
            final MyObject myObject = new MyObject();
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    myObject.setValue("a","aa");
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(500);

            Thread thread02 = new Thread(){
                @Override
                public void run() {
                    myObject.printUsernamePassword();
                }
            };

            thread02.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
