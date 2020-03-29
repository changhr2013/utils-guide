package com.changhr.utils.concurrent.onjava.tasks;// concurrent/SingleThreadExecutor2.java

import java.util.concurrent.*;
import java.util.stream.*;

public class SingleThreadExecutor2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}