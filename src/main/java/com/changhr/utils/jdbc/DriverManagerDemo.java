package com.changhr.utils.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author changhr
 * @create 2019-11-21 16:05
 */
public class DriverManagerDemo {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        InputStream propIn = DriverManagerDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(propIn);

        // 1. 驱动的全类名
        String driverClass = properties.getProperty("driver");
        // 2. 准备连接数据的基本信息：url, user, password
        String url = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        // 3. 加载数据库驱动程序（对应的 Driver 实现类中有注册驱动的静态代码块）
        Class.forName(driverClass);

        // 4. 通过 DriverManager 的 getConnection() 方法获取数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

}
