package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.SynchronizedObject;
import com.brianway.learning.java.xms.thread.ThreadInterrupt07;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadInterrupt07 {
    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            ThreadInterrupt07 interrupt07 = new ThreadInterrupt07(object);
            interrupt07.start();
            Thread.sleep(200);
            interrupt07.stop();
            System.out.println(object.getUsername() + " " + object.getPassword());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
