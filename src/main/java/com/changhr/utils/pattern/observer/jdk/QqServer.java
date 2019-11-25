package com.changhr.utils.pattern.observer.jdk;

import java.util.Observable;

/**
 * @author changhr
 * @create 2019-11-25 15:06
 */
public class QqServer extends Observable {

    public void setInformation(String message) {
        super.setChanged();
        super.notifyObservers(message);
    }
}
