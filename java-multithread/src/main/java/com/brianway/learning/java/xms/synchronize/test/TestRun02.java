package com.brianway.learning.java.xms.synchronize.test;

import com.brianway.learning.java.xms.synchronize.service.MyThread03;
import com.brianway.learning.java.xms.synchronize.service.MyThread04;
import com.brianway.learning.java.xms.synchronize.service.MyThread05;
import com.brianway.learning.java.xms.synchronize.service.Task;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class TestRun02 {
    public static void main(String[] args) {
        Task task = new Task();
        MyThread03 thread01 = new MyThread03(task);
        thread01.setName("a");
        thread01.start();

        MyThread04 thread02 = new MyThread04(task);
        thread02.setName("b");
        thread02.start();
//        thread02.start();  java.lang.IllegalThreadStateException

        MyThread05 thread03 = new MyThread05(task);
        thread03.setName("b");
        thread03.start();
    }
}
