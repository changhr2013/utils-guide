package com.changhr.utils.concurrent.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author changhr
 * @create 2019-11-19 14:21
 */
public class ReentrantLockForIncrease {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    static int cnt = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                int n = 10000;
                while (n > 0) {
                    cnt++;
                    n--;
                }
                reentrantLock.unlock();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();

            System.out.println(cnt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
