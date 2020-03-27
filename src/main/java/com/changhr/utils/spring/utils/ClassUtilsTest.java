package com.changhr.utils.spring.utils;

import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author changhr
 * @create 2019-12-09 17:04
 */
public class ClassUtilsTest {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> aClass1 = ClassUtils.resolveClassName("com.changhr.utils.spring.utils.ClassUtilsTest", ClassUtils.getDefaultClassLoader());
        Constructor<?> constructor = ClassUtils.getConstructorIfAvailable(aClass1);
        Object aInstance = constructor.newInstance();
        Method sum = ClassUtils.getMethodIfAvailable(aClass1, "sum", String.class, String.class);
        sum.invoke(aInstance, "Hello, ", "World!");

        ReflectionUtils.doWithMethods(aClass1,
                method -> System.out.println("method name:" + method.getName()),
                method -> method.getName().equals("sum"));
    }

    public String sum(String a, String b) {
        System.out.println(a + b);
        return a + b;
    }

    public String test(String test) {
        System.out.println(test);
        return test;
    }

}
