package com.changhr.utils.spring.lookupmethod;

/**
 * @author changhr
 * @create 2019-11-26 16:15
 */
public class Student extends User {

    @Override
    public void showMe() {
        System.out.println("I am a student.");
    }
}
