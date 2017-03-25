package com.brianway.learning.java.xms.myVolatile.test;

import com.brianway.learning.java.xms.myVolatile.t99.PrintString;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class TestRunPrintString {
    public static void main(String[] args) {
        /**
         * main 线程执行循环，无法停止
         */
        PrintString printString = new PrintString();
        printString.printStringMethod();

        System.out.println("停止：" + Thread.currentThread().getName());

        printString.setContinuePrint(false);
    }
}
