package com.changhr.utils.listeners;

/**
 * @author changhr
 * @create 2019-11-21 17:52
 */
public class ObserverTest {

    public static void main(String[] args) {
        // 被监听对象
        Thief thief = new Thief();

        // 监听器，直接 new 一个接口的匿名类对象
        ThiefListener thiefListener = new ThiefListener() {
            @Override
            public void shot(Event event) {
                System.out.println("啪啪啪！！！");
            }
        };

        // 注册监听
        thief.registerListener(thiefListener);

        // 特定行为触发监听器，内部调用 listener.shot();
        thief.steal();
    }
}
