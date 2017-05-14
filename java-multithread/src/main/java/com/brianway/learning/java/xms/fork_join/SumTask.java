package com.brianway.learning.java.xms.fork_join;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class SumTask extends RecursiveTask<Integer> {
    private static final int LIMIT = 5000000;

    private long[] array;

    private int low;

    private int high;

    public SumTask(long[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (high - low <= LIMIT) {
            // 小于阈值则直接计算
            for (int i = low; i < high; i++) {
                sum += array[i];
            }
        }else {
            // 1. 一个大任务分割成两个小任务
            int mid = (low + high) >>> 1;
            SumTask left = new SumTask(array,low,mid);
            SumTask right = new SumTask(array,mid,high);

            // 2. 分别计算
            left.fork();
            right.fork();

            // 3. 合并结果
            sum += left.join() + right.join();
        }

        return sum;
    }

    public static void main(String[] args) throws Exception{
        long[] array = genArray(5000000);

        System.out.println(Arrays.toString(array));

        // 1. 创建任务
        SumTask sumTask = new SumTask(array,0,array.length-1);

        long begin = System.currentTimeMillis();

        // 2. 创建线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 3. 提交任务到线程池
        forkJoinPool.submit(sumTask);

        // 4. 获取结果
        Integer result = sumTask.get();

        long end = System.currentTimeMillis();

        System.out.println(String.format("结果 %s 耗时 %s ms",result,(end - begin)));


    }

    private static long[] genArray(int size){
        long[] array = new long[size];
        for (int i =0;i<size;i++){
            array[i] =i;
        }
        return array;
    }

}
