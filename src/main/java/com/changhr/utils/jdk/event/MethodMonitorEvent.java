package com.changhr.utils.jdk.event;

import java.util.EventObject;

/**
 * @author changhr
 * @create 2019-11-27 14:56
 */
public class MethodMonitorEvent extends EventObject {

    /** 时间戳，用于记录方法开始执行时间 */
    public long timeStamp;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MethodMonitorEvent(Object source) {
        super(source);
    }
}
