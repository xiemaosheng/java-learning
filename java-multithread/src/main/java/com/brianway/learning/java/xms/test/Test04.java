package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.Thread03;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class Test04 {
    public static void main(String args[]){
        Thread03 myThread = new Thread03();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
