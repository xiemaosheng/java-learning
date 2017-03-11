package com.brianway.learning.java.xms.threadLocal.transaction.test;

import com.brianway.learning.java.xms.threadLocal.transaction.service.ProductService;
import com.brianway.learning.java.xms.threadLocal.transaction.service.impl.ProductServiceImpl;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class Test02 {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        productService.updateProductPrice(1,200);
    }
}
