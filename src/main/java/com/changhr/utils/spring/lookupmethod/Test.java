package com.changhr.utils.spring.lookupmethod;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author changhr
 * @create 2019-11-26 16:09
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/lookup/lookupTest.xml");
        GetBeanTest test = (GetBeanTest) context.getBean("getBeanTest");
        test.showMe();
    }

}
