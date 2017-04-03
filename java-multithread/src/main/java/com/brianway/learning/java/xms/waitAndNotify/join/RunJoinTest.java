package com.brianway.learning.java.xms.waitAndNotify.join;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class RunJoinTest {
    public static void main(String[] args) {
        try {
            JoinThread thread = new JoinThread();
            thread.start();
            thread.join();
            System.out.println("end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
