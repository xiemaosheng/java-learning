package com.brianway.learning.java.xms.waitAndNotify.run;

import com.brianway.learning.java.xms.waitAndNotify.MyStack;
import com.brianway.learning.java.xms.waitAndNotify.test.C_StackThread;
import com.brianway.learning.java.xms.waitAndNotify.test.P_StackThread;

/**
 * Created by Administrator on 2017/4/2 0002.
 */
public class TestRun02 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P_StackThread p_stackThread = new P_StackThread(myStack);
        C_StackThread c_stackThread = new C_StackThread(myStack);
        C_StackThread c1_stackThread = new C_StackThread(myStack);
        C_StackThread c2_stackThread = new C_StackThread(myStack);
        C_StackThread c3_stackThread = new C_StackThread(myStack);
        p_stackThread.start();
        c_stackThread.start();
//        c1_stackThread.start();
//        c2_stackThread.start();
//        c3_stackThread.start();
    }
}
