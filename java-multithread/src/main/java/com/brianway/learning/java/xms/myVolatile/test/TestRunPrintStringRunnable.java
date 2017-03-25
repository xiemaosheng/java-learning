package com.brianway.learning.java.xms.myVolatile.test;

import com.brianway.learning.java.xms.myVolatile.t99.PrintStringRunnable;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class TestRunPrintStringRunnable {
    public static void main(String[] args) throws Exception{
        /**
         * main主程设置 false，新线程执行循环
         */
        PrintStringRunnable printStringRunnable = new PrintStringRunnable();
        new Thread(printStringRunnable).start();

        System.out.println("停止：" + Thread.currentThread().getName());
        Thread.sleep(1000);
        printStringRunnable.setContinuePrint(false);
    }
}
