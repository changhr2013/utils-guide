package com.changhr.utils.concurrent.onjava.tasks;// concurrent/Futures.java

import java.util.concurrent.*;

public class Futures {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService exec = Executors.newSingleThreadExecutor();

        Future<Integer> f = exec.submit(new CountingTask(99));

        // [1]
        System.out.println(f.get());
        exec.shutdown();
    }
}