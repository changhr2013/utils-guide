package com.changhr.utils.pattern.observer.base;

/**
 * 被观察者接口
 *
 * @author changhr
 * @create 2019-11-25 14:38
 */
public interface Observable {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void deleteObservers();

    void notifyObservers();

    int countObservers();
}
