package com.changhr.utils.concurrent.onjava.tasks;// concurrent/QuittingCompletable.java

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class QuittingCompletable {

    public static void main(String[] args) {

        List<QuittableTask> tasks =
                IntStream.range(1, QuittingTasks.COUNT)
                        .mapToObj(QuittableTask::new)
                        .collect(Collectors.toList());

        List<CompletableFuture<Void>> cfutures =
                tasks.stream()
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        cfutures.forEach(CompletableFuture::join);
    }
}