package com.example.lesson_3.task_2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    public static int getCounter() {
        lock.lock();
        try {
            return counter;
        }finally {
            lock.unlock();
        }
    }

    public static void increase() {
        lock.lock();
        counter++;
        try {
            lock.newCondition().await(500, TimeUnit.MICROSECONDS);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
