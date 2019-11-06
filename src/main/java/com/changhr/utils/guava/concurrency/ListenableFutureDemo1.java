package com.changhr.utils.guava.concurrency;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.*;
import org.apache.commons.lang3.time.StopWatch;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.List;
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

        ListeningExecutorService service = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(8, 16,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(256),
                new ThreadFactoryBuilder().setNameFormat("work-thread-%d").build()));

        CountDownLatch countDownLatch = new CountDownLatch(3);

        ListenableFuture<Integer> work1Future = service.submit(new ComputeCallable());
        ListenableFuture<Integer> work2Future = service.submit(new ComputeCallable());

        ListenableFuture<List<Integer>> composeFutures = Futures.allAsList(Arrays.asList(work1Future, work2Future));

        Futures.addCallback(composeFutures, new FutureCallback<List<Integer>>() {
            @Override
            public void onSuccess(@Nullable List<Integer> result) {
                assert result != null;
                result.forEach(System.out::println);
            }

            @Override
            public void onFailure(Throwable t) {
                throw new RuntimeException(t);
            }
        }, service);


        // 返回一个新的 ListenableFuture，其结果是将给定的 AsyncFunction 应用于给定的 ListenableFuture 的结果
        ListenableFuture<Integer> queueWork1Future = Futures.transformAsync(work1Future, new AsyncFunction<Integer, Integer>() {
            @Override
            public ListenableFuture<Integer> apply(@Nullable Integer input) throws Exception {
                return service.submit(() -> {
                    System.out.println(input + 1);
                    return input + 1;
                });
            }
        }, service);

        Futures.addCallback(queueWork1Future, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    assert result != null;
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

        Futures.addCallback(work1Future, new FutureCallback<Integer>() {
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

        Futures.addCallback(work2Future, new FutureCallback<Integer>() {
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
        resultMap.forEach((key, value) -> System.out.println(key + " : " + value));

        stopWatch.stop();
        System.out.println(stopWatch.getTime(TimeUnit.MILLISECONDS));

        service.shutdown();
    }
}
