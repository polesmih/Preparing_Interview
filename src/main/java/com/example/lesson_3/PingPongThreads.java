package com.example.lesson_3;

public class PingPongThreads {
    public synchronized void print(String str) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " - " + str);
        Thread.sleep(500);
    }

    public static void main(String[] args) throws InterruptedException{
        PingPongThreads pingPongThreads = new PingPongThreads();

        new Thread(() -> {
            while (true) {
                synchronized (pingPongThreads) {
                    try {
                        pingPongThreads.notify();
                        pingPongThreads.print("Ping");
                        pingPongThreads.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(500);

        new Thread(() -> {
            while (true) {
                synchronized (pingPongThreads) {
                    try {
                        pingPongThreads.notify();
                        pingPongThreads.print("Pong");
                        pingPongThreads.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
