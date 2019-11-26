package com.changhr.utils.spring.replacedmethod;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author changhr
 * @create 2019-11-26 16:22
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/replaced/replacedTest.xml");
        TestChangeMethod testChangeMethod = (TestChangeMethod) context.getBean("testChangeMethod");
        testChangeMethod.changeMe();
    }
}
