package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadDaemon;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadDaemon {
    public static void main(String[] args) {
        try {
            ThreadDaemon threadDaemon = new ThreadDaemon();
            threadDaemon.setDaemon(true);
            threadDaemon.start();
            Thread.sleep(5000);
            System.out.println("我离开了thread对象也不在打印了，也就是停止了");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
