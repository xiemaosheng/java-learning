package com.brianway.learning.java.xms.threadLocal.transaction.service.impl;

import com.brianway.learning.java.xms.threadLocal.transaction.service.ProductService;
import com.brianway.learning.java.xms.threadLocal.transaction.util.DbUtil;
import com.brianway.learning.java.xms.threadLocal.transaction.util.DbUtil01;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class ProductServiceImpl01 implements ProductService {
    private static final String UPDATE_PRODUCT_SQL = "update product set price = ? where id = ?";
    private static final String INSERT_LOG_SQL = "insert into log(descp) values(?)";

    @Override
    public void updateProductPrice(long productId, double price) {
        try {
            Connection connection = DbUtil01.getConnection();
            connection.setAutoCommit(false);       // 关闭自动提交事务

            updateProduct(connection,UPDATE_PRODUCT_SQL,productId,price);

            insertLog(connection,INSERT_LOG_SQL,"create product:"+ price);

            connection.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil01.closeConnection();
        }
    }

    private void updateProduct(Connection connection,String sql,long id,double price) throws Exception{
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setDouble(1,price);
        pstm.setLong(2,id);

        int rows = pstm.executeUpdate();

        if (rows != 0){
            System.out.println("update product success");
        }
    }

    private void insertLog(Connection connection,String sql,String desc) throws Exception{
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,desc);
        int rows = pstm.executeUpdate();
        if (0 != rows){
            System.out.println("insert log success");
        }
    }
}
