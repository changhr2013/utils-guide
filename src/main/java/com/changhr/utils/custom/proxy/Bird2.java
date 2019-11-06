package com.changhr.utils.custom.proxy;

/**
 * 继承鸟类
 *
 * @author changhr
 * @create 2019-10-08 14:01
 */
public class Bird2 extends Bird {

    @Override
    public void fly() {
        final long start = System.currentTimeMillis();

        super.fly();

        final long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
