package com.changhr.utils.aop.factory;

import com.changhr.utils.aop.annotation.SimpleTransactional;
import com.changhr.utils.aop.utils.ConnectionUtils;
import com.changhr.utils.aop.utils.TransactionManager;

/**
 * Bean 工厂
 *
 * @author changhr
 * @create 2019-11-21 14:32
 */
public class BeanFactory {

    public Object getBean(String name) throws Exception {
        // 得到目标类的 Class 对象
        Class<?> clazz = Class.forName(name);
        // 得到目标对象
        Object target = clazz.newInstance();
        // 得到目标类上的 @SimpleTransactional 注解
        SimpleTransactional simpleTransactional = clazz.getAnnotation(SimpleTransactional.class);
        // 如果打了@SimpleTransactional 注解，返回代理对象，否则返回目标对象
        if (simpleTransactional != null) {
            ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
            TransactionManager transactionManager = new TransactionManager();
            transactionManager.setConnectionUtils(new ConnectionUtils());

            proxyFactoryBean.setTarget(target);
            proxyFactoryBean.setTxManager(transactionManager);
            // 装配通知和目标对象
            // 返回代理对象
            return proxyFactoryBean.getProxy();
        }
        // 返回目标对象
        return target;
    }
}
