package com.changhr.utils.custom.proxy.demo2.dynamic;

import com.changhr.utils.custom.proxy.demo2.IUserDao;
import com.changhr.utils.custom.proxy.demo2.UserDao;

/**
 * @author changhr
 * @create 2019-10-09 10:18
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());

        IUserDao proxy = (IUserDao)new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());

        proxy.save();
    }
}
