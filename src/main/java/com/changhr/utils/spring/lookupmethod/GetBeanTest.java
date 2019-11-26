package com.changhr.utils.spring.lookupmethod;

/**
 * @author changhr
 * @create 2019-11-26 16:07
 */
public abstract class GetBeanTest {

    public abstract User getBean();

    public void showMe() {
        this.getBean().showMe();
    }
}
