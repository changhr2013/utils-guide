package com.changhr.utils.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author changhr
 * @create 2019-11-21 15:56
 */
public class DriverDemo {

    public static void main(String[] args) throws SQLException {
        // 1. 创建一个 Driver 实现类的对象
        Driver driver = new Driver();

        // 2. 准备连接数据库的基本信息
        String url = "jdbc:mysql://localhost:3306/rest_boot?useSSL=true";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "123456");

        // 3. 调用 Driver 接口的 connect(url, info) 获取数据库连接
        Connection connection = driver.connect(url, info);
        System.out.println(connection);
    }
}
