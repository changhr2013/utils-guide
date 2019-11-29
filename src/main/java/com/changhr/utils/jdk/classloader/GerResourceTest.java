package com.changhr.utils.jdk.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 示例寻找 Array.class 文件
 *
 * @author changhr
 * @create 2019-11-27 14:25
 */
public class GerResourceTest {

    public static void main(String[] args) throws IOException {
        String name = "java/sql/Array.class";
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(name);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }
    }

}
