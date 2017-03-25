package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class ObjectService {
    public void serviceMethod(){
        try {
            // 对象监视器
            synchronized (this){
                System.out.println("begin time : " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time : " + System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void test(){
        try {
            synchronized (this){
                System.out.println("begin time : " + System.currentTimeMillis());
                System.out.println("end time : " + System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
