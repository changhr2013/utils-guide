package com.changhr.utils.guava.concurrency;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.*;
import org.apache.commons.lang3.time.StopWatch;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.*;

/**
 * @author changhr
 * @create 2019-08-02 11:06
 */
@SuppressWarnings("Duplicates")
public class ListenableFutureDemo1 {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        ConcurrentMap<String, Integer> resultMap = Maps.newConcurrentMap();

        CountDownLatch countDownLatch = new CountDownLatch(3);

        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture<Integer> explosion1 = service.submit(new ComputeCallable());
        ListenableFuture<Integer> explosion2 = service.submit(new ComputeCallable());

        ListenableFuture<Long> longexplosion1 = Futures.transformAsync(explosion1, new AsyncFunction<Integer, Long>() {
            @Override
            public ListenableFuture<Long> apply(@Nullable Integer input) throws Exception {
                return service.submit(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        long result = 0;
                        for (Integer i = 0; i < input; i++) {
                            result += i;
                        }
                        return result;
                    }
                });
            }
        }, service);

        Futures.addCallback(longexplosion1, new FutureCallback<Long>() {
            @Override
            public void onSuccess(@Nullable Long result) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    resultMap.put(Thread.currentThread().getName(), result.intValue());
                } finally {
                    countDownLatch.countDown();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                try {
                    t.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        }, service);

        Futures.addCallback(explosion1, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    resultMap.put(Thread.currentThread().getName(), result);
                } finally {
                    countDownLatch.countDown();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                try {
                    t.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        }, service);

        Futures.addCallback(explosion2, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    resultMap.put(Thread.currentThread().getName(), result);
                } finally {
                    countDownLatch.countDown();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                try {
                    t.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        }, service);

        countDownLatch.await();
        resultMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        stopWatch.stop();
        System.out.println(stopWatch.getTime(TimeUnit.MILLISECONDS));

        service.shutdown();
    }
}
