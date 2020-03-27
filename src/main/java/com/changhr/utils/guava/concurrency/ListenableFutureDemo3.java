package com.changhr.utils.guava.concurrency;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author changhr
 * @create 2020-03-26 18:10
 */
public class ListenableFutureDemo3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<String> resultList = Lists.newArrayList();

        ListeningExecutorService service = MoreExecutors.listeningDecorator(
                new ThreadPoolExecutor(8, 16,
                        0L, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(256),
                        new ThreadFactoryBuilder().setNameFormat("work-thread-%d").build()));

        ListenableFuture<String> work1Future = service.submit(new BuildStringCallable("first"));
        ListenableFuture<String> work2Future = service.submit(new BuildStringCallable("second"));
        ListenableFuture<String> work3Future = service.submit(new BuildStringCallable("three"));

        ListenableFuture<List<String>> composeFutures = Futures.allAsList(Arrays.asList(work1Future, work2Future, work3Future));

        //Futures.addCallback(composeFutures, new FutureCallback<List<String>>() {
        //
        //    @Override
        //    public void onSuccess(@Nullable List<String> result) {
        //            assert result != null;
        //            resultList.addAll(result);
        //    }
        //
        //    @Override
        //    public void onFailure(Throwable t) {
        //            throw new RuntimeException(t);
        //    }
        //}, service);

        resultList = Futures.getDone(composeFutures);

        resultList.forEach(System.out::println);
    }


}
