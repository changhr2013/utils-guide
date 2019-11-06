package com.changhr.utils.custom.proxy;

import java.lang.Override;
import java.lang.reflect.Method;

public class DynamicProxy implements Flyable {
  private InvocationHandler handler;

  public DynamicProxy(InvocationHandler handler) {
    this.handler = handler;
  }

  @Override
  public void run() {
    try{
    	 Method method = com.changhr.utils.custom.proxy.Flyable.class.getMethod("run");
    	 this.handler.invoke(this, method, null);
    } catch(Exception e) {
    	e.printStackTrace();
    }
  }

  @Override
  public void fly() {
    try{
    	 Method method = com.changhr.utils.custom.proxy.Flyable.class.getMethod("fly");
    	 this.handler.invoke(this, method, null);
    } catch(Exception e) {
    	e.printStackTrace();
    }
  }
}
