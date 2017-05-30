package com.brianway.learning.java.xms.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/5/30 0030.
 */
public class ExchangerTest {
    private final static Exchanger<String> exchanger = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    exchanger.exchange(A);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";
                    String A = exchanger.exchange(B);
                    System.out.println("A和B的数据是否一致：" + A.equals(B) + ",A录入的是：" + A + ",B录入的是：" + B);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
