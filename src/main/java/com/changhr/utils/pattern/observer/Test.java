package com.changhr.utils.pattern.observer;

import com.changhr.utils.pattern.observer.base.User;
import com.changhr.utils.pattern.observer.base.WeChatServer;
import com.changhr.utils.pattern.observer.jdk.QqServer;
import com.changhr.utils.pattern.observer.jdk.QqUser;

/**
 * @author changhr
 * @create 2019-11-25 14:59
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("张三");
        User user2 = new User("李四");
        User user3 = new User("王五");

        WeChatServer weChatServer = new WeChatServer();
        weChatServer.addObserver(user1);
        weChatServer.addObserver(user2);
        weChatServer.addObserver(user3);

        weChatServer.setInformation("明天天气晴朗");

        QqUser qqUser1 = new QqUser("Tom");
        QqUser qqUser2 = new QqUser("Jerry");
        QqUser qqUser3 = new QqUser("Jack");

        QqServer qqServer = new QqServer();
        qqServer.addObserver(qqUser1);
        qqServer.addObserver(qqUser2);
        qqServer.addObserver(qqUser3);

        qqServer.setInformation("Tomorrow has wind");

    }

}
