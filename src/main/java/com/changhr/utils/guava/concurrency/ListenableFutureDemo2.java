package com.changhr.utils.guava.concurrency;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.*;
import org.apache.commons.lang3.time.StopWatch;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author changhr
 * @create 2019-08-02 11:06
 */
@SuppressWarnings("Duplicates")
public class ListenableFutureDemo2 {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        ConcurrentMap<String, Integer> resultMap = Maps.newConcurrentMap();

        System.out.println("当前线程为：" + Thread.currentThread().getName());
        int result = 0;
        for (int i = 0; i < 1000000000; i++) {
            result += i;
        }
        resultMap.put(Thread.currentThread().getName(), result);

        System.out.println("当前线程为：" + Thread.currentThread().getName());
        int result2 = 0;
        for (int i = 0; i < 1000000000; i++) {
            result2 += i;
        }
        resultMap.put(Thread.currentThread().getName(), result2);

        resultMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        stopWatch.stop();
        System.out.println(stopWatch.getTime(TimeUnit.MILLISECONDS));

    }
}
