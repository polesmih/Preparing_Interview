package com.example.lesson_2;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList {
    private final int DEFAULT_CAPACITY = 8;
    private final double FILL_FACTOR = 0.7;
    private final int RAISING_FACTOR = 2;

    private int capacity;
    private int size;
    private E[] array;

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        array = (E[]) new Object[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public E get(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index - " + index + ", Size - " + size);
        }
        return array[index];
    }

    @Override
    public boolean add(Object elem) {
        if (elem == null) {
            return false;
        }
        if (size > (int) capacity * FILL_FACTOR) {
            array = createNewArray();
        }
        array[size] = (E) elem;
        size++;
        return true;
    }

    private E[] createNewArray() {
        capacity = capacity * RAISING_FACTOR;
        E[] newArray = (E[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }


    @Override
    public void insert(int index, Object elem) {
        if (index < 0) {
            return;
        }
        if (size + 1 >= capacity) {
            increaseCapacity();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = (E) elem;
        size++;

    }

    private void increaseCapacity() {
        capacity = capacity * 2;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = (E[]) newArray;
    }

    @Override
    public E delete(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index - " + index + ", Size - " + size);
        }
        E result = array[index];
        E[] newArray = (E[]) new Object[capacity];
        E[] partArray = Arrays.copyOfRange(array, 0, index);
        System.arraycopy(partArray, 0, newArray, 0, partArray.length);

        partArray = Arrays.copyOfRange(array, index + 1, array.length);
        System.arraycopy(partArray, 0, newArray, index, size - index);
        size--;
        array = newArray;
        return result;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
