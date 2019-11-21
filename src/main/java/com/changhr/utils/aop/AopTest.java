package com.changhr.utils.aop;

import com.changhr.utils.aop.factory.BeanFactory;
import com.changhr.utils.aop.service.UserService;
import com.changhr.utils.aop.service.impl.UserServiceImpl;

/**
 * @author changhr
 * @create 2019-11-21 14:48
 */
public class AopTest {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        try {
            Object bean = beanFactory.getBean("com.changhr.utils.aop.service.impl.UserServiceImpl");
            System.out.println(bean.getClass().getName());
            UserService userService = (UserService) bean;
            userService.getUser();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
