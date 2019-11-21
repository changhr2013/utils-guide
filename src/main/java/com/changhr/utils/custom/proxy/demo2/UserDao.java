package com.changhr.utils.custom.proxy.demo2;

/**
 * @author changhr
 * @create 2019-10-09 10:04
 */
public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
