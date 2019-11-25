package com.changhr.utils.spring.advance.annotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author changhr
 * @create 2019-11-25 10:18
 */
@ToString
@Component
public class Person {

    @Qualifier("bmw")
    @Autowired
    private Car car;
}
