package com.changhr.utils.listeners;

/**
 * @author changhr
 * @create 2019-11-21 17:47
 */
public class Thief {

    private ThiefListener listener;

    public void registerListener(ThiefListener listener) {
        this.listener = listener;
    }

    public void steal() {
        // 偷之前，告诉警察
        if (listener != null) {
            Event event = new Event(this);
            // 喂，有胆开枪啊！
            listener.shot(event);
        }
        // 偷东西
        System.out.println("to steal money...");
    }

}
