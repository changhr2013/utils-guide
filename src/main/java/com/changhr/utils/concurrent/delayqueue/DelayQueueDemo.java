package com.changhr.utils.concurrent.delayqueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author changhr
 * @create 2019-08-20 14:36
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executorService = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        for (int i = 0; i < 5; i++) {
            // 填充有随机延迟的任务
            queue.put(new DelayedTask(random.nextInt(3000)));
        }
        // 设置停止点
        queue.add(new EndSentinel(3000, executorService));
        executorService.execute(new DelayedTaskConsumer(queue));
    }
}

