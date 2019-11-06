package com.changhr.utils.custom.proxy.jdk.statc;

import com.changhr.utils.custom.proxy.jdk.IUserDao;
import com.changhr.utils.custom.proxy.jdk.UserDao;

/**
 * @author changhr
 * @create 2019-10-09 10:10
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        IUserDao target = new UserDao();

        final UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
