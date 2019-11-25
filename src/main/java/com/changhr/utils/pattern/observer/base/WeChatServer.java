package com.changhr.utils.pattern.observer.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changhr
 * @create 2019-11-25 14:48
 */
public class WeChatServer implements Observable {

    private List<Observer> list;

    private String message;

    public WeChatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public synchronized void deleteObserver(Observer observer) {
        if (!list.isEmpty()) {
            list.remove(observer);
        }
    }

    @Override
    public synchronized void deleteObservers() {
        list.clear();
    }

    @Override
    public synchronized void notifyObservers() {
        for (Observer observer : list) {
            observer.update(message);
        }
    }

    @Override
    public synchronized int countObservers() {
        return list.size();
    }

    public void setInformation(String message){
        this.message = message;
        System.out.println("微信服务更新消息：" + message);
        notifyObservers();
    }
}
