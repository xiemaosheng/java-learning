package com.brianway.learning.java.xms.ReentrantLock;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class LockConditionThreadB extends Thread {
    private LockConditionService lockConditionService;

    public LockConditionThreadB(LockConditionService lockConditionService){
        this.lockConditionService = lockConditionService;
    }

    @Override
    public void run() {
        lockConditionService.awaitB();
    }
}
