package com.changhr.utils.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁
 * 公平锁：加锁前检查是否有排队等待的线程，优先排队等待的线程，先来先得
 * 非公平锁：加锁时不考虑排队等待问题，直接尝试获取锁，获取不到自动到队尾等待
 *
 * @author changhr
 * @create 2019-08-20 10:18
 */
public class FairLock {

    private ReentrantLock lock;

    public FairLock(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        lock.lock();
        try {
            System.out.println("ThreadName= " + Thread.currentThread().getName() + " 获得锁定，queue length = " + lock.getQueueLength());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final FairLock service = new FairLock(true);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println("我进来了 " + Thread.currentThread().getName());
                service.serviceMethod();
            });
        }
        executorService.shutdown();
    }
}
