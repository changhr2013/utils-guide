package com.changhr.utils.concurrent.onjava.future;// concurrent/Batter.java

import com.changhr.utils.concurrent.onjava.tasks.Nap;

import java.util.concurrent.*;

public class Batter {

    static class Eggs {
    }

    static class Milk {
    }

    static class Sugar {
    }

    static class Flour {
    }

    static <T> T prepare(T ingredient) {
        new Nap(0.1);
        return ingredient;
    }

    static <T> CompletableFuture<T> prep(T ingredient) {
        return CompletableFuture
                .completedFuture(ingredient)
                .thenApplyAsync(Batter::prepare);
    }

    public static CompletableFuture<Batter> mix() {

        CompletableFuture<Eggs> eggs = prep(new Eggs());

        CompletableFuture<Milk> milk = prep(new Milk());

        CompletableFuture<Sugar> sugar = prep(new Sugar());

        CompletableFuture<Flour> flour = prep(new Flour());

        CompletableFuture.allOf(eggs, milk, sugar, flour).join();

        // Mixing time
        new Nap(0.1);

        return CompletableFuture.completedFuture(new Batter());
    }
}