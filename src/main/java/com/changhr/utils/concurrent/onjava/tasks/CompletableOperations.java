package com.changhr.utils.concurrent.onjava.tasks;// concurrent/CompletableOperations.java

import java.util.concurrent.*;

import static com.changhr.utils.concurrent.onjava.tasks.CompletableUtilities.*;


public class CompletableOperations {

    static CompletableFuture<Integer> cfi(int i) {
        return CompletableFuture.completedFuture(Integer.valueOf(i));
    }

    public static void main(String[] args) {

        showr(cfi(1)); // Basic test

        // 含有“then”的方法将进一步的操作应用于现有的 CompletableFuture 。

        // 调用 runAsync() 的示例。由于 Runnable 不产生返回值，因此结果是 CompletableFuture，因此使用 voidr()。
        voidr(cfi(2).runAsync(() -> System.out.println("runAsync")));

        voidr(cfi(3).thenRunAsync(() -> System.out.println("thenRunAsync")));

        // runAsync() 是一个静态方法，所以你不会像 cfi(2) 一样调用它。相反你可以在 QuittingCompletable.java 中使用它。
        voidr(CompletableFuture.runAsync(() -> System.out.println("runAsync is static")));

        // supplyAsync() 也是静态方法，但是需要一个 Supplier 而不是 Runnable
        // 并产生一个 CompletableFuture 来代替 CompletableFuture。
        showr(CompletableFuture.supplyAsync(() -> 99));

        // 与 thenRunAsync() 不同的是，将 cfi(4)，cfi(5) 和 cfi(6) 的“then”方法作为未包装的 Integer 的参数。
        // AcceptAsync() 接受了一个 Consumer，因此不会产生结果。
        voidr(cfi(4).thenAcceptAsync(i -> System.out.println("thenAcceptAsync: " + i)));

        // thenApplyAsync() 接受一个 Function 并因此产生一个结果（该结果的类型可以不同于其参数）。
        showr(cfi(5).thenApplyAsync(i -> i + 42));

        // thenComposeAsync() 与 thenApplyAsync() 非常相似，
        // 不同之处在于其 Function 必须产生已经包装在 CompletableFuture 中的结果。
        showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));

        // cfi(7) 示例演示了 obtrudeValue()，它强制将值作为结果。
        CompletableFuture<Integer> c = cfi(7);
        c.obtrudeValue(111);
        showr(c);

        // cfi(8) 使用 toCompletableFuture() 从 CompletionStage 生成 CompletableFuture。
        showr(cfi(8).toCompletableFuture());

        // c.complete(9) 显示了如何通过给它一个结果来完成一个任务（future）
        // （与 obtrudeValue() 相对，后者可能会迫使其结果替换该结果）。
        c = new CompletableFuture<>();
        c.complete(9);
        showr(c);

        // 如果你调用 CompletableFuture 中的 cancel() 方法，它也会完成并且是非常好的完成。
        c = new CompletableFuture<>();
        c.cancel(true);
        System.out.println("cancelled: " + c.isCancelled());
        System.out.println("completed exceptionally: " + c.isCompletedExceptionally());
        System.out.println("done: " + c.isDone());
        System.out.println(c);

        // 如果任务（future）未完成，则 getNow() 方法返回 CompletableFuture 的完成值，
        // 或者返回 getNow() 的替换参数。
        c = new CompletableFuture<>();
        System.out.println(c.getNow(777));

        // 如果我们将两个 thenApplyAsync() 调用链接到 CompletableFuture 上，则依赖项的数量仍为 1。
        c = new CompletableFuture<>();
        c.thenApplyAsync(i -> i + 42).thenApplyAsync(i -> i * 12);
        System.out.println("dependents: " + c.getNumberOfDependents());

        // 如果我们将另一个 thenApplyAsync() 直接附加到 c，
        // 则现在有两个依赖项：两个链和另一个链。
        // 这表明你可以拥有一个 CompletionStage，当它完成时，可以根据其结果派生多个新任务。
        c.thenApplyAsync(i -> i / 2);
        System.out.println("dependents: " + c.getNumberOfDependents());
    }
}