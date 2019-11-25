package com.changhr.utils.spring.extensions.beanfactorypostprocess;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * InitialingBean 在属性设置完毕后做一些自定义操作
 * DisposableBean 在关闭容器前做一些操作
 *
 * @author changhr
 * @create 2019-11-25 17:49
 */
@Component
@Scope("prototype")
public class OneBean implements InitializingBean, DisposableBean {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OneBean() {
    }

    public OneBean(String name, String message) {
        this.name = name;
        this.message = message;
    }

    /**
     * 在执行 System.exit(0) 后，执行 destroy 方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.err.println("[DisposableBean][destroy] destroy");
    }

    /**
     * 在执行 Set 属性方法后，立即执行 afterPropertiesSet 方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("[InitializingBean][afterPropertiesSet] init");

    }
}
