package com.brianway.learning.java.base.reflect.rpc.test;

import com.brianway.learning.java.base.reflect.rpc.RpcFramework;
import com.brianway.learning.java.base.reflect.rpc.service.HelloService;
import com.brianway.learning.java.base.reflect.rpc.service.impl.HellloServiceImpl;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public class RpcProvider {
    public static void main(String[] args) {
        try {
            HelloService service = new HellloServiceImpl();
            RpcFramework.export(service,1235);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
