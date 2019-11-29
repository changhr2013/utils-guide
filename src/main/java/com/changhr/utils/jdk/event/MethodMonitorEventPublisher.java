package com.changhr.utils.jdk.event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author changhr
 * @create 2019-11-27 15:04
 */
public class MethodMonitorEventPublisher {

    private List<MethodMonitorEventListener> listeners = new ArrayList<>();

    public void methodMonitor() throws InterruptedException {
        MethodMonitorEvent eventObject = new MethodMonitorEvent(this);
        publishEvent("begin", eventObject);
        TimeUnit.SECONDS.sleep(3);
        publishEvent("end", eventObject);
    }

    private void publishEvent(String status, MethodMonitorEvent event) {
        // 避免在事件处理期间，监听器被移除，这里为了安全做一个复制操作
        List<MethodMonitorEventListener> copyListeners = new ArrayList<>(listeners);
        for (MethodMonitorEventListener listener : copyListeners) {
            if ("begin".equals(status)) {
                listener.onMethodBegin(event);
            }else {
                listener.onMethodEnd(event);
            }
        }
    }

    public void addEventListener(MethodMonitorEventListener listener){
        listeners.add(listener);
    }

    public void removeEventListener(MethodMonitorEventListener listener){
        listeners.remove(listener);
    }

    public void removeAllListeners() {
        listeners.clear();
    }

    public static void main(String[] args) throws InterruptedException {
        MethodMonitorEventPublisher publisher = new MethodMonitorEventPublisher();
        publisher.addEventListener(new AbstractMethodMonitorEventListener());
        publisher.methodMonitor();
    }
}
