package com.brianway.learning.java.xms.synchronize.test;

import com.brianway.learning.java.xms.synchronize.service.*;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class TestRunThreadStaticSyn {
    public static void main(String[] args) throws Exception{
        /**
         * static synchronized method
         */
//        ThreadStaticSyn01 threadStaticSyn01 = new ThreadStaticSyn01();
//        threadStaticSyn01.setName("threadStaticSyn01");
//        threadStaticSyn01.start();
//
//        ThreadStaticSyn02 threadStaticSyn02 = new ThreadStaticSyn02();
//        threadStaticSyn02.setName("threadStaticSyn02");
//        threadStaticSyn02.start();

        /**
         * 异步执行的原因：持有不同的锁，一个是对象锁，一个是Class锁，其中Class锁可以对类的所有对象实例起作用
         */

//        Service service = new Service();
//        ThreadStaticSyn03 threadStaticSyn03 = new ThreadStaticSyn03(service);
//        threadStaticSyn03.setName("threadStaticSyn03");
//        threadStaticSyn03.start();
//
//        ThreadStaticSyn04 threadStaticSyn04 = new ThreadStaticSyn04(service);
//        threadStaticSyn04.setName("threadStaticSyn04");
//        threadStaticSyn04.start();
//
//        ThreadStaticSyn05 threadStaticSyn05 = new ThreadStaticSyn05(service);
//        threadStaticSyn05.setName("threadStaticSyn05");
//        threadStaticSyn05.start();


        /**
         * 同步：lass锁可以对类的所有对象实例起作用
         */
//        Service service = new Service();
//        Service service1 = new Service();
//        Service service2 = new Service();
//        ThreadStaticSyn03 threadStaticSyn03 = new ThreadStaticSyn03(service1);
//        threadStaticSyn03.setName("threadStaticSyn03");
//        threadStaticSyn03.start();
//
//        ThreadStaticSyn04 threadStaticSyn04 = new ThreadStaticSyn04(service2);
//        threadStaticSyn04.setName("threadStaticSyn04");
//        threadStaticSyn04.start();

//        ThreadStaticSyn05 threadStaticSyn05 = new ThreadStaticSyn05(service);  // 不同的锁，异步
//        threadStaticSyn05.setName("threadStaticSyn05");
//        threadStaticSyn05.start();


        /**
         * 同步synchronized(class) 代码块 的作用和synchronized static 方法作用一致；
         */
        Service service1 = new Service();
        Service service2 = new Service();
        ThreadStaticSyn06 threadStaticSyn06 = new ThreadStaticSyn06(service1);
        threadStaticSyn06.setName("threadStaticSyn06");
        threadStaticSyn06.start();

        ThreadStaticSyn07 threadStaticSyn07 = new ThreadStaticSyn07(service2);
        threadStaticSyn07.setName("threadStaticSyn07");
        threadStaticSyn07.start();

    }
}
