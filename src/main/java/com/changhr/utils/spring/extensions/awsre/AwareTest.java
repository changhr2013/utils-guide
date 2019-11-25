package com.changhr.utils.spring.extensions.awsre;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 在 Bean 中获取到 ApplicationContext 和 beanFactory
 * @author changhr
 * @create 2019-11-25 17:31
 */
@Component
public class AwareTest implements BeanNameAware, ApplicationContextAware, BeanFactoryAware {

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("[BeanFactoryAware][setBeanFactory] " + beanFactory);
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("[BeanNameAware][setBeanName] " + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("[ApplicationContextAware][setApplicationContext] " + applicationContext);
    }
}
