package com.changhr.utils.spring.extensions.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author changhr
 * @create 2019-11-25 9:55
 */
@Component
@Scope("prototype")
public class CalculatorImpl implements Calculator,
        BeanNameAware, ApplicationContextAware, BeanFactoryAware, BeanClassLoaderAware,
        InitializingBean, DisposableBean, FactoryBean {

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    private ClassLoader classLoader;

    @Override
    public void add(int a, int b) {
        System.out.println("a+b=" + (a + b));
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("[CalculatorImpl][BeanFactoryAware][setBeanFactory] " + beanFactory);
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("[CalculatorImpl][BeanNameAware][setBeanName] " + beanName);
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("[CalculatorImpl][DisposableBean][destroy]");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("[CalculatorImpl][InitializingBean][afterPropertiesSet]");
    }

    @PostConstruct
    public void init(){
        System.out.println("[CalculatorImpl][@PostConstruct][init-method]");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("[CalculatorImpl][@PreDestroy][destroy-method]");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("[CalculatorImpl][ApplicationContextAware][setApplicationContext] " + applicationContext);
    }

    @Override
    public Object getObject() throws Exception {
        System.out.println("[CalculatorImpl][FactoryBean][getObject]");
        return new CalculatorImpl();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("[CalculatorImpl][FactoryBean][getObjectType]");
        return CalculatorImpl.class;
    }

    @Override
    public boolean isSingleton() {
        System.out.println("[CalculatorImpl][FactoryBean][isSingleton]");
        return true;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        System.out.println("[CalculatorImpl][BeanClassLoaderAware][setBeanClassLoader] " + classLoader);
    }

}
