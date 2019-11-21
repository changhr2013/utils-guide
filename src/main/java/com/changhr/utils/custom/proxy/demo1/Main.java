package com.changhr.utils.custom.proxy.demo1;

import com.changhr.utils.custom.proxy.demo1.base.Bird;
import com.changhr.utils.custom.proxy.demo1.dynamic.MyInvocationHandler;
import com.changhr.utils.custom.proxy.demo1.base.Flyable;
import com.changhr.utils.custom.proxy.demo1.statc.BirdLogProxy;
import com.changhr.utils.custom.proxy.demo1.statc.BirdTimeProxy;
import com.changhr.utils.custom.proxy.demo1.utils.Proxy;

/**
 * 静态代理
 * 局限性：1. 如果同时代理多个类，依然会导致类无限制扩展
 *         2. 如果类中有多个方法，同要的逻辑需要反复实现
 * @author changhr
 * @create 2019-10-08 14:08
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("========== ========== ==========");

        final Bird bird = new Bird();
        final BirdTimeProxy p1 = new BirdTimeProxy(bird);
        final BirdLogProxy p2 = new BirdLogProxy(p1);

        p2.fly();

        System.out.println("========== ========== ==========");

        final Bird bird2 = new Bird();
        final BirdLogProxy p3 = new BirdLogProxy(bird2);
        final BirdTimeProxy p4 = new BirdTimeProxy(p3);

        p4.fly();

        System.out.println("========== ========== ==========");

        Bird dynamicBird = new Bird();
        Flyable flyable = (Flyable) Proxy.newProxyInstance(Flyable.class, new MyInvocationHandler(dynamicBird));
        flyable.fly();
        flyable.run();

        System.out.println("========== ========== ==========");

    }

}
