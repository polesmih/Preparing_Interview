package com.example.lesson_2;

import java.util.Iterator;

public interface MyList<E> extends Iterable<E>{
    E get(int index);
    boolean add (E elem);
    void insert(int index, E elem);
    E delete(int index);

}
