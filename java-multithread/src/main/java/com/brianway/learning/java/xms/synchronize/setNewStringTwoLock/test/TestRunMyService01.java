package com.brianway.learning.java.xms.synchronize.setNewStringTwoLock.test;

import com.brianway.learning.java.xms.synchronize.setNewStringTwoLock.MyService;
import com.brianway.learning.java.xms.synchronize.setNewStringTwoLock.ThreadService01;
import com.brianway.learning.java.xms.synchronize.setNewStringTwoLock.ThreadService02;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class TestRunMyService01 {
    public static void main(String[] args) throws Exception{
        /**
         * 50 毫秒过后线程B获取的锁是“456”
         */
        MyService myService = new MyService();
        ThreadService01 threadSerivce01 = new ThreadService01(myService);
        threadSerivce01.setName("a");

        ThreadService02 threadService02 = new ThreadService02(myService);
        threadService02.setName("b");

        threadSerivce01.start();
        Thread.sleep(1);
        threadService02.start();

    }
}
