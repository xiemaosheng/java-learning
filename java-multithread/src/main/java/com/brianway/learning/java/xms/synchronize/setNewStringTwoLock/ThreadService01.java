package com.brianway.learning.java.xms.synchronize.setNewStringTwoLock;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class ThreadService01 extends Thread{
    private MyService myService;

    public ThreadService01(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        super.run();
        myService.testMethod();
    }
}
