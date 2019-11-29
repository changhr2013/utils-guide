package com.changhr.utils.spring.extensions.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author changhr
 * @create 2019-11-25 9:56
 */
@Component
public class MyAspectJAutoProxyCreator implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("\n[MyAspectJAutoProxyCreator][postProcessBeforeInitialization]");
        System.out.println(o);
        System.out.println(o.getClass());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("[MyAspectJAutoProxyCreator][postProcessAfterInitialization]\n");
        final Object bean = o;
        System.out.println(o.getClass());

        if (bean instanceof Calculator) {
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("start calculate");
                        Object invoke = method.invoke(bean, args);
                        System.out.println("end calculate");
                        return invoke;
                    });
        }
        return bean;
    }
}
