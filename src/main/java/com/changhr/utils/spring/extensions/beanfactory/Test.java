package com.changhr.utils.spring.extensions.beanfactory;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author changhr
 * @create 2019-12-09 10:12
 */
public class Test {

    public static void main(String[] args) {
//        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/test/beanFactory/BeanFactory.xml"));
//        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) beanFactory.getBean("bfpp");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/test/beanFactory/BeanFactory.xml");
        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) context.getBean("bfpp");
        System.out.println(bfpp);
        System.out.println(bfpp.getClass());
        System.out.println(context.getBean("simpleBean"));
    }

}
