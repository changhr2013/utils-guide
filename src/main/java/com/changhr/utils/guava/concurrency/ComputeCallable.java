package com.changhr.utils.guava.concurrency;

import java.util.concurrent.Callable;

/**
 * @author changhr
 * @create 2019-08-02 11:22
 */
public class ComputeCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        int result = 0;
        for (int i = 0; i < 100000000; i++) {
            result += i;
        }
        return result;
    }
}
