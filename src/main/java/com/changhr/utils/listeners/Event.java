package com.changhr.utils.listeners;

/**
 * 事件对象
 * 就是包装后的被监听对象
 *
 * @author changhr
 * @create 2019-11-21 17:49
 */
public class Event {

    private Thief thief;

    public Event(Thief thief) {
        this.thief = thief;
    }

    public Thief getThief() {
        return thief;
    }

    public void setThief(Thief thief) {
        this.thief = thief;
    }
}
