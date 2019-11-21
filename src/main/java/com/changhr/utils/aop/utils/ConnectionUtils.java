package com.changhr.utils.aop.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

/**
 * @author changhr
 * @create 2019-11-21 14:06
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rest_boot?useUnicode=true&useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }

    /**
     * 获取当前线程上的连接
     *
     * @return Connection
     */
    public Connection getThreadConnection() {
        try {
            // 1. 先从 ThreadLocal 上获取
            Connection connection = connectionThreadLocal.get();
            // 2. 判断当前线程上是否有连接
            if (connection == null) {
                // 3. 从数据源中获取一个连接，并且存入 ThreadLocal 中
                connection = dataSource.getConnection();
                connectionThreadLocal.set(connection);
            }
            // 4. 返回当前线程上的连接
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        connectionThreadLocal.remove();
    }

}
