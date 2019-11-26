package com.changhr.utils.spring.replacedmethod;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author changhr
 * @create 2019-11-26 16:19
 */
public class TestMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("我替换了原有的方法");
        return null;
    }
}
