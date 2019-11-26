package com.changhr.utils.spring.lookupmethod;

/**
 * @author changhr
 * @create 2019-11-26 16:06
 */
public class Teacher extends User {

    @Override
    public void showMe() {
        System.out.println("I am a teacher.");
    }
}
