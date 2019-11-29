package com.changhr.utils.spring.extensions.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author changhr
 * @create 2019-11-25 16:25
 */
//@Component
public class FactoryBeanTest implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new Aop();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanTest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
