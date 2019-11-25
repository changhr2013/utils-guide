package com.changhr.utils.spring.advance.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author changhr
 * @create 2019-11-25 10:47
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context5.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

}
