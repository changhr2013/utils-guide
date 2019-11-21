package com.changhr.utils.custom.proxy.demo2.statc;

import com.changhr.utils.custom.proxy.demo2.IUserDao;

/**
 * @author changhr
 * @create 2019-10-09 10:05
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");
    }
}
