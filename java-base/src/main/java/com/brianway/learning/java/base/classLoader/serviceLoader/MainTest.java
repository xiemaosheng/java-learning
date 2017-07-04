package com.brianway.learning.java.base.classLoader.serviceLoader;

import java.util.ServiceLoader;

/**
 * 实现打包jar包时，需要在META-INF/services/com.brianway.learning.java.base.classLoader.serviceLoader.HDFSServiceImpl
 * META-INF/services/com.brianway.learning.java.base.classLoader.serviceLoader.LocalServiceImpl
 * Created by Administrator on 2017/7/4 0004.
 */
public class MainTest {
    public static void main(String[] args) {
        ServiceLoader<IService> serviceLoader = ServiceLoader.load(IService.class);
        for (IService service : serviceLoader){
            System.out.println(service.getScheme());
        }
    }
}
