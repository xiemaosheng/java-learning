package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.MyThread02;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class Test03 {
    public static void main(String args[]){
        MyThread02 a = new MyThread02("A");
        MyThread02 b = new MyThread02("B");
        MyThread02 c = new MyThread02("C");
        a.start();
        b.start();
        c.start();
    }
}
