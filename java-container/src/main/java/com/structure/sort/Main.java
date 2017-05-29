package com.structure.sort;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Executor executor = Executors.newCachedThreadPool();
        int[] arr = {11, 155, 22, 77, 3, 4, 9, 24, 65, 27};
        for (int a:arr){
            System.out.println(a);
        }
        System.out.println("--------------------");
        int start = 0;
        while (OddEventSortTask.getExchFlag() == 1 || start == 1) {
            OddEventSortTask.setExchFlag(0);
            CountDownLatch latch = new CountDownLatch(arr.length / 2 - (arr.length % 2 == 0 ? start : 0));
            for (int i = start; i < arr.length - 1; i += 2) {
                executor.execute(new OddEventSortTask(i,arr, latch));
            }

            latch.await();

            if (start == 0) {
                start = 1;
            } else {
                start = 0;
            }
        }
        for (int a:arr){
            System.out.println(a);
        }
    }
}
