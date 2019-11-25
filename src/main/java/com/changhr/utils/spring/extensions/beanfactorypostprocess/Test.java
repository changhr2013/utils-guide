package com.changhr.utils.spring.extensions.beanfactorypostprocess;

import com.changhr.utils.spring.extensions.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author changhr
 * @create 2019-11-25 17:50
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OneBean bean = applicationContext.getBean(OneBean.class);
        System.out.println(bean);
        System.exit(0);
    }

}
