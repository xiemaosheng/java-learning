package com.brianway.learning.java.xms.threadLocal.transaction.test;

import com.brianway.learning.java.xms.threadLocal.transaction.service.ProductService;
import com.brianway.learning.java.xms.threadLocal.transaction.service.impl.ProductServiceImpl01;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class ClientThread01 extends Thread{
    private ProductService productService;

    public ClientThread01(ProductService productService){
        this.productService = productService;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        productService.updateProductPrice(3,213333);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++){
            ProductService productService = new ProductServiceImpl01();
            ClientThread01 clientThread = new ClientThread01(productService);
            clientThread.start();
        }
    }
}
