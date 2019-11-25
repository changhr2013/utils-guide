package com.changhr.utils.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author changhr
 * @create 2019-11-25 15:06
 */
public class QqUser implements Observer {

    private String name;

    private String message;

    public QqUser(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.message = (String)arg;
        read();
    }

    private void read() {
        System.out.println(name + " receive message: " + message);
    }
}
