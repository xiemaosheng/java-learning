package com.brianway.learning.java.xms.synchronize.dealLockThread;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class DealThread implements Runnable{
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setFlag(String username){
        this.username = username;
    }

    @Override
    public void run() {
        if ("a".equals(username)){
            synchronized (lock1){
                try {
                    System.out.println("username =" + username);
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("按 lock1 --> lock2 代码顺序执行了");
                }
            }
        }

        if ("b".equals(username)){
            synchronized (lock2){
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("按 lock2 --> lock1 代码顺序执行了");
                }
            }
        }
    }

}
