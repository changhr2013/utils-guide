package com.changhr.utils.guava.concurrency;

import java.util.concurrent.Callable;

/**
 * @author changhr
 * @create 2020-03-26 17:42
 */
public class BuildStringCallable implements Callable<String> {

    private String prefix;

    public BuildStringCallable(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String call() throws Exception {
        return prefix + "123";
    }
}
