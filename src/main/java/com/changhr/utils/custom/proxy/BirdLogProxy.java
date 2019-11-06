package com.changhr.utils.custom.proxy;

/**
 * 日志聚合
 *
 * @author changhr
 * @create 2019-10-08 14:06
 */
public class BirdLogProxy implements Flyable {

    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {

        System.out.println("Bird fly start...");

        flyable.fly();

        System.out.println("Bird fly end...");
    }

    @Override
    public void run() {
        System.out.println("Bird run start...");

        flyable.run();

        System.out.println("Bird run end...");
    }
}
