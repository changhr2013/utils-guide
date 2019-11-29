package com.changhr.utils.jdk.event;

/**
 * 事件监听接口的实现：如何处理
 *
 * @author changhr
 * @create 2019-11-27 15:00
 */
public class AbstractMethodMonitorEventListener implements MethodMonitorEventListener {

    @Override
    public void onMethodBegin(MethodMonitorEvent event) {
        // 记录方法开始执行时间
        event.timeStamp = System.currentTimeMillis();
    }

    @Override
    public void onMethodEnd(MethodMonitorEvent event) {
        // 计算方法耗时
        long duration = System.currentTimeMillis() - event.timeStamp;
        System.out.println("耗时：" + duration);
    }
}
