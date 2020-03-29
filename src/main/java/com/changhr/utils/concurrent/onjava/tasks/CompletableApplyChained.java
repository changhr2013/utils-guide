package com.changhr.utils.concurrent.onjava.tasks;// concurrent/CompletableApplyChained.javaimport java.util.concurrent.*;

import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;

public class CompletableApplyChained {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(new Machina(0))
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}