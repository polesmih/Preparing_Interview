package com.example;

import com.example.lesson_2.MyArrayList;
import com.example.lesson_2.MyLinkedList;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            myLinkedList.add("test - " + i);
        }

        myLinkedList.add("1_test");
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.get(58));
        System.out.println(myLinkedList.getLast());

        MyArrayList<String> myArrayList = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            myArrayList.add("test - " + i);
        }
        myArrayList.delete(5);

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println(myArrayList.get(i));

        }

    }
}
