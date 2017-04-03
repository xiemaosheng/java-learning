package com.brianway.learning.java.xms.waitAndNotify.test;

import com.brianway.learning.java.xms.waitAndNotify.MyStack;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class C_StackThread extends Thread {
    private MyStack myStack;
    public C_StackThread(MyStack myStack){
        this.myStack = myStack;
    }

    @Override
    public void run() {
        while (true){
            myStack.pop();
        }
    }
}
