package com.changhr.utils.reflects;

/**
 * @author changhr
 * @create 2019-11-22 14:26
 */
public class Test {

    public void printVersion() {
        System.out.println("current version is 2");
        System.out.println(this.getClass().getClassLoader());
    }
}
