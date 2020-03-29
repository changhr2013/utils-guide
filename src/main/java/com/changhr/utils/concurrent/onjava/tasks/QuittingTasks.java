package com.changhr.utils.concurrent.onjava.tasks;// concurrent/QuittingTasks.java

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class QuittingTasks {
    public static final int COUNT = 150;

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        List<QuittableTask> tasks =
                IntStream.range(1, COUNT)
                        .mapToObj(QuittableTask::new)
                        .peek(es::execute)
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }
}