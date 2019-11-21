package com.changhr.utils.aop.factory;

import com.changhr.utils.aop.utils.TransactionManager;
import net.sf.cglib.proxy.Proxy;

/**
 * 代理 Bean 工厂
 *
 * @author changhr
 * @create 2019-11-21 14:38
 */
public class ProxyFactoryBean {

    /**
     * 通知
     */
    private TransactionManager txManager;

    /**
     * 目标对象
     */
    private Object target;


    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 传入目标对象 target，为它装配好通知，返回代理对象
     *
     * @return Object 代理对象
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    try {
                        // 1. 开启事务
                        txManager.beginTransaction();
                        // 2. 执行操作
                        Object result = method.invoke(target, args);
                        // 3. 提交事务
                        txManager.commit();
                        // 4. 返回结果
                        return result;
                    } catch (Exception e) {
                        // 5. 回滚事务
                        txManager.rollback();
                        throw new RuntimeException(e);
                    } finally {
                        // 6. 释放连接
                        txManager.release();
                    }
                });
    }
}
