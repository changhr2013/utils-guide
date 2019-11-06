package com.changhr.utils.custom.proxy;

import java.lang.reflect.Method;

/**
 * 处理自定义逻辑
 *
 * @author changhr
 * @create 2019-10-08 15:53
        */
public interface InvocationHandler {
    void invoke(Object proxy, Method method, Object[] args);
}
