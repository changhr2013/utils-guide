package com.changhr.utils.custom.proxy.demo1.statc;

import com.changhr.utils.custom.proxy.demo1.base.Bird;

/**
 * 继承鸟类
 *
 * @author changhr
 * @create 2019-10-08 14:01
 */
public class StaticProxyBird extends Bird {

    @Override
    public void fly() {
        final long start = System.currentTimeMillis();

        super.fly();

        final long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
