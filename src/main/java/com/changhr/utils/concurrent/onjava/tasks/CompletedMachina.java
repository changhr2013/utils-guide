package com.changhr.utils.concurrent.onjava.tasks;// concurrent/CompletedMachina.java

import java.util.concurrent.*;

public class CompletedMachina {
    public static void main(String[] args) {

        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        try {
            // Doesn't block
            Machina m = cf.get();
        } catch (InterruptedException |
                ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}