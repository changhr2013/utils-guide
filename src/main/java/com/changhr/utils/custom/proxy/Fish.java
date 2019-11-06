package com.changhr.utils.custom.proxy;

import java.util.Random;

/**
 * 鱼类
 *
 * @author changhr
 * @create 2019-10-08 15:46
 */
public class Fish implements Flyable {

    @Override
    public void fly() {
        System.out.println("Fish is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Fish is Running...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
