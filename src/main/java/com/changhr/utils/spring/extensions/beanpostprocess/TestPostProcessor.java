package com.changhr.utils.spring.extensions.beanpostprocess;

import com.changhr.utils.spring.extensions.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author changhr
 * @create 2019-11-25 10:02
 */
public class TestPostProcessor {

    public static void main(String[] args) {
        System.out.println("容器启动成功");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("================");

        Calculator bean = context.getBean(Calculator.class);
        System.out.println(bean.getClass());
        bean.add(1, 2);
    }
}
