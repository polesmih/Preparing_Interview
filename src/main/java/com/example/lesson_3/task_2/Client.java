package com.example.lesson_3.task_2;

public class Client implements Runnable{

    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Counter.increase();
            System.out.println("Counter - " + Counter.getCounter() + ", client - " + name);
        }
    }
}
