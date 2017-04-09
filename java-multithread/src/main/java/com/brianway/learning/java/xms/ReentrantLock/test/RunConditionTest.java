package com.brianway.learning.java.xms.ReentrantLock.test;

import com.brianway.learning.java.xms.ReentrantLock.*;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class RunConditionTest {
    public static void main(String[] args) throws Exception{
        LockConditionService lockConditionService = new LockConditionService();

        LockConditionThreadA lockConditionThreadA = new LockConditionThreadA(lockConditionService);


        lockConditionThreadA.setName("A");
        lockConditionThreadA.start();

        LockConditionThreadB lockConditionThreadB = new LockConditionThreadB(lockConditionService);

        lockConditionThreadB.setName("B");
        lockConditionThreadB.start();

        Thread.sleep(30000);
        lockConditionService.signAllA();

    }
}
