package com.brianway.learning.java.xms.synchronize.stringAndSyn.test;

import com.brianway.learning.java.xms.synchronize.stringAndSyn.StringService;
import com.brianway.learning.java.xms.synchronize.stringAndSyn.StringThread01;
import com.brianway.learning.java.xms.synchronize.stringAndSyn.StringThread02;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class TestRunString01 {
    public static void main(String[] args) {
        /**
         * 打印情况都是输出：A... 原因：String的两个值都是‘String’，两个线程持有相同的锁，所以造成线程B不能执行；
         * 这就是String 常量池所带来问题；
         * 大多数情况下：同步synchronized代码块都不使用String作为锁对象，而改用其他；比如 new Object()实例化一个Object对象。但它不放人缓存中
         *
         * 在JVM 中具有 String常量池缓存的功能
         */
        StringService stringService = new StringService();
        StringThread01 stringThread01 = new StringThread01(stringService);
        stringThread01.setName("A");
        stringThread01.start();

        StringThread02 stringThread02 = new StringThread02(stringService);
        stringThread02.setName("B");
        stringThread02.start();
    }
}
