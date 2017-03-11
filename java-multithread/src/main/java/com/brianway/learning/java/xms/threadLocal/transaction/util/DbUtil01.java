package com.brianway.learning.java.xms.threadLocal.transaction.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class DbUtil01 {
    // 数据库配置
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static final String username = "root";
    private static final String password = "123456";

    // 改进：定义一个用于放置数据库连接的局部线程变量（使每个线程都拥有自己的连接）
//    private static Connection connection = null;

    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();
    public static Connection getConnection() {
        Connection connection = connContainer.get();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connContainer.set(connection);
        }
        return connection;
    }

    public static void closeConnection(){
        Connection connection = connContainer.get();
        try {
            if (null != connection){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connContainer.remove();
        }
    }
}
