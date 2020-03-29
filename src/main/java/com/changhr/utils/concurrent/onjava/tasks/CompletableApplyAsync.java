package com.changhr.utils.concurrent.onjava.tasks;// concurrent/CompletableApplyAsync.java

import java.util.concurrent.*;

import org.springframework.util.StopWatch;

public class CompletableApplyAsync {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work);

        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

        stopWatch.start();
        System.out.println(cf.join());
        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeMillis());
    }
}