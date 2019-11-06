package com.changhr.utils.concurrent.delayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static com.changhr.utils.concurrent.delayqueue.Print.printnb;
import static java.util.concurrent.TimeUnit.*;

class DelayedTask implements Runnable, Delayed {

        private static int counter = 0;
        private final int id = counter++;
        private final int delta;
        private final long trigger;

        protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

        public DelayedTask(int delayInMilliseconds) {
            delta = delayInMilliseconds;
            trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
            sequence.add(this);
        }

        @Override
        public int compareTo(Delayed arg) {
            DelayedTask that = (DelayedTask) arg;
            return Long.compare(trigger, that.trigger);
        }

        @Override
        public void run() {
            printnb(this + " ");
        }

        @Override
        public String toString(){
            return String.format("[%1$-4d]", delta) + " Task " + id;
        }

        public String summary(){
            return "(" + id + ":" + delta + ")";
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
        }
    }