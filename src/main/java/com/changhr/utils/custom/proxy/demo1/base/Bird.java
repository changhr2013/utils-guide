package com.changhr.utils.custom.proxy.demo1.base;

import java.util.Random;

/**
 * 鸟类
 *
 * @author changhr
 * @create 2019-10-08 13:59
 */
public class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try{
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Bird is Running...");
        try{
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
