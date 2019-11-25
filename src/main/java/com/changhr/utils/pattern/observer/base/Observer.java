package com.changhr.utils.pattern.observer.base;

/**
 * 抽象观察者接口
 * 定义了一个 update() 方法，当被观察者调用 notifyObservers() 方法时，观察者的 update() 方法会被回调
 * @author changhr
 * @create 2019-11-25 14:42
 */
public interface Observer {
    void update(String message);
}
