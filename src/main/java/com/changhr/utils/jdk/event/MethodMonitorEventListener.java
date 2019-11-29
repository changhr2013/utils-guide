package com.changhr.utils.jdk.event;

import java.util.EventListener;

/**
 * 定义事件监听接口
 *
 * @author changhr
 * @create 2019-11-27 14:58
 */
public interface MethodMonitorEventListener extends EventListener {

    /**
     * 处理方法执行之前发布的事件
     *
     * @param event 事件
     */
    void onMethodBegin(MethodMonitorEvent event);

    /**
     * 处理方法结束时发布的事件
     * @param event 事件
     */
    void onMethodEnd(MethodMonitorEvent event);
}
