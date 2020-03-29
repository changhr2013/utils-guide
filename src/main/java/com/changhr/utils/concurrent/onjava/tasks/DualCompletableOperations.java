package com.changhr.utils.concurrent.onjava.tasks;// concurrent/DualCompletableOperations.java

import java.util.concurrent.*;

import static com.changhr.utils.concurrent.onjava.tasks.CompletableUtilities.*;

public class DualCompletableOperations {

    static CompletableFuture<Workable> cfA, cfB;

    // init() 总是使用较短的延迟（因此总是“获胜”）使用“B”初始化两者。
    static void init() {
        cfA = Workable.make("A", 0.15);
        // Always wins
        cfB = Workable.make("B", 0.10);
    }

    static void join() {
        cfA.join();
        cfB.join();
        System.out.println("*****************");
    }

    public static void main(String[] args) {

        // 任意一个任务执行完后立即执行指定方法
        init();
        voidr(cfA.runAfterEitherAsync(cfB, () -> System.out.println("runAfterEither")));
        join();

        // 两个任务都执行完后立即执行指定方法
        init();
        voidr(cfA.runAfterBothAsync(cfB, () -> System.out.println("runAfterBoth")));
        join();

        // 将任意执行完成的 CompletableFuture 加入到有效负载中
        init();
        showr(cfA.applyToEitherAsync(cfB, w -> {
            System.out.println("applyToEither: " + w);
            return w;
        }));
        join();

        // lambda 接收任意一个执行完成的 CompletableFuture
        init();
        voidr(cfA.acceptEitherAsync(cfB, w -> {
            System.out.println("acceptEither: " + w);
        }));
        join();

        // lambda 接收两个执行完成的 CompletableFuture
        init();
        voidr(cfA.thenAcceptBothAsync(cfB, (w1, w2) -> {
            System.out.println("thenAcceptBoth: " + w1 + ", " + w2);
        }));
        join();

        // 等待两个 CompletableFuture 完成，然后将它们都交给 BiFunction，
        // 然后 BiFunction 可以将结果加入到所得 CompletableFuture 的有效负载中。
        init();
        showr(cfA.thenCombineAsync(cfB, (w1, w2) -> {
            System.out.println("thenCombine: " + w1 + ", " + w2);
            return w2;
        }));
        join();

        // 任意一个 CompletableFuture 执行完成后执行 lambda
        init();
        CompletableFuture<Workable>
                cfC = Workable.make("C", 0.08),
                cfD = Workable.make("D", 0.09);

        CompletableFuture.anyOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() -> System.out.println("anyOf"));
        join();

        // 所有 CompletableFuture 执行完成后执行 lambda
        init();
        cfC = Workable.make("C", 0.08);
        cfD = Workable.make("D", 0.09);
        CompletableFuture.allOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() -> System.out.println("allOf"));
        join();
    }
}