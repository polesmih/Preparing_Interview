package com.example;

import com.example.lesson_3.task_2.Client;

public class Main {
    public static void main(String[] args) {
        new Thread(new Client("1")).start();
        new Thread(new Client("2")).start();
        new Thread(new Client("3")).start();
        new Thread(new Client("4")).start();
        new Thread(new Client("5")).start();

    }
}
