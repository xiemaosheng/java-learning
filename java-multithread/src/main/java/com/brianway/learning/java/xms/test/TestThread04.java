package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.Thread04;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThread04 {
    public static void main(String[] args) {
        Thread04 thread04 = new Thread04();
//        thread04.start(); // thread04 构造函数由main线程创建，start（）方法会用 thread04线程去调用run
        thread04.run(); // 之间调用，是由main线程调用
    }
}
