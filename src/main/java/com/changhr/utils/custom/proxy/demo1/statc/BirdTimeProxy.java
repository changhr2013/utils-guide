package com.changhr.utils.custom.proxy.demo1.statc;

import com.changhr.utils.custom.proxy.demo1.base.Flyable;

/**
 * 聚合
 *
 * @author changhr
 * @create 2019-10-08 14:03
 */
public class BirdTimeProxy implements Flyable {

    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        final long start = System.currentTimeMillis();

        flyable.fly();

        final long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end -  start));
    }

    @Override
    public void run() {
        final long start = System.currentTimeMillis();

        flyable.run();

        final long end = System.currentTimeMillis();
        System.out.println("Run time = " + (end -  start));
    }
}
