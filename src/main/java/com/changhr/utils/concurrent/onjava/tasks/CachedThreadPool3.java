package com.changhr.utils.concurrent.onjava.tasks;// concurrent/CachedThreadPool3.java

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class CachedThreadPool3 {

    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        List<CountingTask> tasks =
                IntStream.range(0, 10)
                        .mapToObj(CountingTask::new)
                        .collect(Collectors.toList());

        List<Future<Integer>> futures = exec.invokeAll(tasks);

        Integer sum = futures.stream()
                .map(CachedThreadPool3::extractResult)
                .reduce(0, Integer::sum);

        System.out.println("sum = " + sum);
        exec.shutdown();
    }
}