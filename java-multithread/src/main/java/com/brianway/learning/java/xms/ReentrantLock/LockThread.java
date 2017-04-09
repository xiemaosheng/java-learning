package com.brianway.learning.java.xms.ReentrantLock;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class LockThread extends Thread {
    private LockService lockService;

    public LockThread(LockService lockService){
        this.lockService = lockService;
    }

    @Override
    public void run() {
        lockService.testMethod();
    }
}
