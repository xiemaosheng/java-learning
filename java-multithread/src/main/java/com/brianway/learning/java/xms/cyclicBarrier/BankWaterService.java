package com.brianway.learning.java.xms.cyclicBarrier;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/5/30 0030.
 */
public class BankWaterService implements Runnable {
    /**
     * 创建四个屏障，处理完之后执行当前类的run
     */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4,this);

    /**
     * 启动四个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个线程计算的结果
     */

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前线程数据，业务逻辑省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // 计算完成，插入一个屏障
                    try {
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet计算出结果
        for (Map.Entry<String,Integer> sheet : sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }

        sheetBankWaterCount.put("result",result);
        System.out.println("result:"+result);

    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
