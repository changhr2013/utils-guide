package com.changhr.utils.guava.concurrency;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ConcurrentMap;
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
        Thread.sleep(2000);
        resultMap.put(Thread.currentThread().getName() + 1, RandomUtil.randomInt(3000));

        System.out.println("当前线程为：" + Thread.currentThread().getName());

        Thread.sleep(2000);
        resultMap.put(Thread.currentThread().getName() + 2, RandomUtil.randomInt(3000));

        resultMap.forEach((key, value) -> System.out.println(key + " : " + value));

        stopWatch.stop();
        System.out.println(stopWatch.getTime(TimeUnit.MILLISECONDS));
    }
}
