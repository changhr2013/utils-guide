package com.changhr.utils.concurrent.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 非公平锁
 *
 * @author changhr
 * @create 2019-08-20 11:12
 */
public class UnFairLock {

    private ReentrantLock unFairLock;

    public UnFairLock(boolean isFair) {
        super();
        unFairLock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        unFairLock.lock();
        try {
            System.out.println("ThreadName= " + Thread.currentThread().getName()
                    + "获得锁定，queue length= " + unFairLock.getQueueLength());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            unFairLock.unlock();
        }
    }

    public static void main(String[] args) {
        final UnFairLock service = new UnFairLock(false);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println("我进来了 " + Thread.currentThread().getName());
                service.serviceMethod();
            });
        }

        executorService.shutdown();
    }
}
