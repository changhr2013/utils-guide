package com.changhr.utils.spring.extensions.beanfactorypostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 在 Bean 创建之前，读取 Bean 的源属性，并根据自己的需求对源属性进行修改
 * @author changhr
 * @create 2019-11-25 17:41
 */
@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    /**
     * 在它的标准初始化之后修改应用程序上下文的内部 Bean 工厂。
     * 所有的 Bean 定义都已经加载了，但是还没有实例化 Bean。
     * 这允许覆盖或添加属性，甚至是对初始化 bean 的属性。
     * @param configurableListableBeanFactory 应用程序上下文所使用的 Bean 工厂
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("calculatorImpl");
        MutablePropertyValues beanProperty = beanDefinition.getPropertyValues();
        System.out.println("scope before change: " + beanDefinition.getScope());
        beanDefinition.setScope("singleton");
        System.out.println("scope after change: " + beanDefinition.getScope());
        System.out.println("beanProperty: " + beanProperty);
    }
}
