package com.changhr.utils.concurrent.delayqueue;

import java.util.concurrent.ExecutorService;

import static com.changhr.utils.concurrent.delayqueue.Print.*;

/**
 * @author changhr
 * @create 2019-08-20 14:51
 */
public class EndSentinel extends DelayedTask {

    private ExecutorService exec;

    public EndSentinel(int delayInMilliseconds, ExecutorService executorService) {
        super(delayInMilliseconds);
        exec = executorService;
    }

    @Override
    public void run() {
        print();
        for (DelayedTask delayedTask : sequence) {
            printnb(delayedTask.summary() + " ");
        }
        print();
        print(this + " Calling shutdownNow()");
        exec.shutdownNow();
    }
}
