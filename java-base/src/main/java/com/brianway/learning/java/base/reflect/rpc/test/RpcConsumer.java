package com.brianway.learning.java.base.reflect.rpc.test;

import com.brianway.learning.java.base.reflect.rpc.RpcFramework;
import com.brianway.learning.java.base.reflect.rpc.service.HelloService;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public class RpcConsumer {
    public static void main(String[] args) {
        try {
            HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1235);
            for (int i = 0;i< Integer.MAX_VALUE;i++){
                String hello = service.hello("World" + i);
                System.out.println(hello);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
