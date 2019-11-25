package com.changhr.utils.spring.extensions.factorybean;

import com.changhr.utils.spring.extensions.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author changhr
 * @create 2019-11-25 16:28
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Object factory = context.getBean("factoryBeanTest");
        System.out.println(factory);
    }
}
