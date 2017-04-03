package com.brianway.learning.java.xms.waitAndNotify.wait_notify_insert_test;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class DBTools {
    private volatile boolean prevIsA = false;

    public synchronized void backupA(){
        try {
            while(prevIsA == true){
                wait();
            }
            for(int i=0;i<5;i++){
                System.out.println("**********");
            }
            prevIsA = true;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void backupB(){
        try {
            while(prevIsA == false){
                wait();
            }
            for (int i =0; i < 5;i++){
                System.out.println("&&&&&&&&&&&&&&");
            }
            prevIsA = false;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
