package com.brianway.learning.java.xms.threadLocal.transaction.test;

import com.brianway.learning.java.xms.threadLocal.transaction.service.ProductService;
import com.brianway.learning.java.xms.threadLocal.transaction.service.impl.ProductServiceImpl;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class ClientThread extends Thread{
    private ProductService productService;

    public ClientThread(ProductService productService){
        this.productService = productService;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        productService.updateProductPrice(2,322);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++){
            ProductService productService = new ProductServiceImpl();
            ClientThread clientThread = new ClientThread(productService);
            clientThread.start();
        }
    }
}
