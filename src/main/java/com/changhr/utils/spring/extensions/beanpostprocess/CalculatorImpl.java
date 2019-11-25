package com.changhr.utils.spring.extensions.beanpostprocess;

import org.springframework.stereotype.Component;

/**
 * @author changhr
 * @create 2019-11-25 9:55
 */
@Component
public class CalculatorImpl implements Calculator {

    @Override
    public void add(int a, int b) {
        System.out.println("a+b=" + (a + b));
    }
}
