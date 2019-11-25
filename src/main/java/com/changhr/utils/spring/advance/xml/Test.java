package com.changhr.utils.spring.advance.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author changhr
 * @create 2019-11-25 10:20
 */
public class Test {

    public static void main(String[] args) {

        // Setter 方法注入
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);

        // 构造方法注入
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("spring-context2.xml");
        Person person2 = (Person) context2.getBean("person");
        System.out.println(person2);

        // 全局自动装配
        ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("spring-context3.xml");
        Person person3 = (Person) context3.getBean("person");
        System.out.println(person3);

        // 局部自动装配
        ClassPathXmlApplicationContext context4 = new ClassPathXmlApplicationContext("spring-context4.xml");
        Person person4 = (Person) context4.getBean("person");
        System.out.println(person4);
    }

}
