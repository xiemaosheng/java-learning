package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadInterrupt02 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0 ; i < 500000 ; i ++){
                if (this.isInterrupted()){
                    System.out.println(" 已经是停止状态了！退出");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }
            System.out.println("输出：线程还没有停止");
        }catch (InterruptedException e){
            System.out.println("进入ThreadInterrupt02 类run方法中的catch了！");
            e.printStackTrace();
        }
    }
}
