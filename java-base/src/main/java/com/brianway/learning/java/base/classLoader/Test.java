package com.brianway.learning.java.base.classLoader;

import java.util.Timer;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerDemo timerDemo = new TimerDemo();

        timer.schedule(timerDemo,1000,2000);   //任务1 一秒钟后执行，每两秒执行一次
    }
}
