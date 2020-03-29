package com.changhr.utils.concurrent.onjava.tasks;// concurrent/Workable.java

import java.util.concurrent.*;

public class Workable {

    String id;

    final double duration;

    public Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable[" + id + "]";
    }

    public static Workable work(Workable tt) {
        // Seconds
        new Nap(tt.duration);
        tt.id = tt.id + "W";
        System.out.println(tt);
        return tt;
    }

    public static CompletableFuture<Workable> make(String id, double duration) {
        // [tip] 将一个对象包装成 CompletableFuture ，然后指定对象要执行的异步方法
        return CompletableFuture.completedFuture(new Workable(id, duration))
                .thenApplyAsync(Workable::work);
    }
}