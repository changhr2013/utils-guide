package com.changhr.utils.pattern.observer.base;

/**
 * @author changhr
 * @create 2019-11-25 14:57
 */
public class User implements Observer {

    private String name;

    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息：" + message);
    }
}
