package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class Thread04 extends Thread {
    public Thread04(){
        System.out.println("构造函数打印：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run 方法打印：" + Thread.currentThread().getName());
    }
}
