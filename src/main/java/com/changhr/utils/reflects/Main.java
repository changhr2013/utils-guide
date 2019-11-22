package com.changhr.utils.reflects;

import com.google.common.collect.Sets;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author changhr
 * @create 2019-11-22 16:12
 */
public class Main {

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                String swapPath = SimpleClassLoader.class.getResource("").getPath() + "swap/";
                String className = "com.changhr.utils.reflects.Test";

                // 每次都实例化一个 ClassLoader，这里传入 swap 路径，和需要特殊加载的类名
                SimpleClassLoader simpleClassLoader = new SimpleClassLoader(swapPath, Sets.newHashSet(className));
                try {
                    // 使用自定义的 ClassLoader 加载类，并调用 printVersion 方法
                    Object o = simpleClassLoader.loadClass(className).newInstance();
                    Test test = new Test();
                    test.printVersion();
//                    Test test = (Test)o;
//                    test.printVersion();
                    o.getClass().getMethod("printVersion").invoke(o);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2000);
    }

}
