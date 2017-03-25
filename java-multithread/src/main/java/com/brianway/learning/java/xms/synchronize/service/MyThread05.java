package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class MyThread05 extends Thread{
    private Task task;
    public MyThread05(Task task){
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.test();
    }
}
