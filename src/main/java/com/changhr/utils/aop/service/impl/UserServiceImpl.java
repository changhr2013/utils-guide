package com.changhr.utils.aop.service.impl;

import com.changhr.utils.aop.annotation.SimpleTransactional;
import com.changhr.utils.aop.service.UserService;

/**
 * 用户服务实现类
 *
 * @author changhr
 * @create 2019-11-21 14:31
 */
@SimpleTransactional
public class UserServiceImpl implements UserService {

    @Override
    public void getUser() {
        System.out.println("user service invoke...");
    }
}
