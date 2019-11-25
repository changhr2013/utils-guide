package com.changhr.utils.spring.advance.xml;

import lombok.ToString;

/**
 * @author changhr
 * @create 2019-11-25 10:18
 */
@ToString
public class Person {
    private Car car;

    public Person(Car car) {
        System.out.println("通过构造方法注入");
        this.car = car;
    }

    public Person() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        System.out.println("通过 Setter 方法注入");
        this.car = car;
    }
}
