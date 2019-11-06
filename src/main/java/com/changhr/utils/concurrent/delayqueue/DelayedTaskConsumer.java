package com.changhr.utils.concurrent.delayqueue;

import java.util.concurrent.DelayQueue;

import static com.changhr.utils.concurrent.delayqueue.Print.*;

/**
 * @author changhr
 * @create 2019-08-20 14:58
 */
public class DelayedTaskConsumer implements Runnable {

    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 使用当前线程运行任务 Task
                q.take().run();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Finished DelayedTaskConsumer");
    }
}
