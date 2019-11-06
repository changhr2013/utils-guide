package com.changhr.utils.custom.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author changhr
 * @create 2019-10-08 16:07
 */
public class MyInvocationHandler implements InvocationHandler {

    private Bird bird;

    public MyInvocationHandler(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void invoke(Object proxy, Method method, Object[] args) {
        final long start = System.currentTimeMillis();
        System.out.println("Fly start...");
        try {
            method.invoke(bird, new Object[] {});
        }catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        final long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
        System.out.println("Fly end...");
    }
}
