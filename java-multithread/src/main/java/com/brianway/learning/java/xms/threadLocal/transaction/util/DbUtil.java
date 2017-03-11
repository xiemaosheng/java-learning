package com.brianway.learning.java.xms.threadLocal.transaction.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class DbUtil {
    // 数据库配置
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static final String username = "root";
    private static final String password = "123456";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if (null != connection){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
