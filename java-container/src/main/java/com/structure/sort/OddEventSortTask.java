package com.structure.sort;

import java.util.concurrent.CountDownLatch;

/**
 * 并行排序（基于奇偶排序）
 * Created by Administrator on 2017/5/29 0029.
 */
public class OddEventSortTask implements Runnable {
    private int i;
    private int[] arr;
    private CountDownLatch latch;

    public static int exchFlag = 1;

    public static synchronized void setExchFlag(int value) {
        exchFlag = value;
    }

    public static synchronized int getExchFlag() {
        return exchFlag;
    }

    public OddEventSortTask(int i, int[] arr,CountDownLatch latch) {
        this.i = i;
        this.arr = arr;
        this.latch = latch;
    }

    @Override
    public void run() {
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            setExchFlag(1);
        }
        latch.countDown();
    }


}
