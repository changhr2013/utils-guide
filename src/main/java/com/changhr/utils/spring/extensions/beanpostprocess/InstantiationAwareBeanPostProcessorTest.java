package com.changhr.utils.spring.extensions.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

/**
 * @author changhr
 * @create 2019-11-25 16:39
 */
@Component
public class InstantiationAwareBeanPostProcessorTest extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("[InstantiationAwareBeanPostProcessor][postProcessBeforeInstantiation] before 实例化：" + beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("[InstantiationAwareBeanPostProcessor][postProcessAfterInstantiation] after 实例化：" + beanName);
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object bean, String beanName) throws BeansException {
        System.out.println("[InstantiationAwareBeanPostProcessor][postProcessPropertyValues] pvs: " + propertyValues);
        System.out.println("[InstantiationAwareBeanPostProcessor][postProcessPropertyValues] pds: " + Arrays.toString(propertyDescriptors));
        System.out.println("[InstantiationAwareBeanPostProcessor][postProcessPropertyValues] beanName: " + beanName);
        return propertyValues;
    }
}
