package com.example.lesson_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>{
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.getContent();
    }

    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.getContent();
    }

    public int getSize() {
        return size;
    }

    @Override
    public E get(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (index >= size || index < 0) {
    throw new IndexOutOfBoundsException("Index - " + index + ", Size - " + size);
        }
        return findNode(index).getContent();
    }

    private Node<E> findNode(int index) {
        return index <= size / 2 ? directFind(index - 1) : reverseFFind(index - 1);
    }

    private Node<E> reverseFFind(int index) {
        Node<E> node = last;
        for (int i = size - 1; i >= 0 ; i--) {
            if (i == index) {
                return node;
            }
            node = node.getPreNode();
        }
            throw new IndexOutOfBoundsException("Index - " + index + ", Size - " + size);
    }

    private Node<E> directFind(int index) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (node.getIndex() == index) {
                return node;
            }
            node = node.getNextNode();
        }
        throw new IndexOutOfBoundsException("Index - " + index + ", Size - " + size);
    }

    private void reindex(Node<E> newNode) {
        for (int i = newNode.getIndex(); i < size; i++) {
            newNode.setIndex(i);
            newNode = newNode.getNextNode();
        }
    }

    @Override
    public boolean add(E elem) {
        if (size == 0) {
            first = new Node<>(size, elem);
            last = first;
        } else {
            Node<E> node = new Node<>(last.getIndex() + 1, elem);
            node.setPreNode(last);
            last.setNextNode(node);
            last = node;
            last.setNextNode(first);
            first.setPreNode(last);
        }
        size++;
        return true;
    }

    @Override
    public void insert(int index, E elem) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index - " + index);
        }
        if (index == 0) {
            insertFirst(elem);
            return;
        }
        if (index == size) {
            insertLast(elem);
            return;
        }
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        Node<E> newNode = new Node<>(current, elem, current.getNextNode());
        current.setNextNode(newNode);
        newNode.getNextNode().setPreNode(newNode);
        size++;

    }

    private void insertLast(E elem) {
        Node<E> newNode = new Node<>(last, elem, null);
        if (isEmpty()) {
            first = newNode;
        }else {
            last.setNextNode(newNode);
        }
        last = newNode;
        size++;
    }

    private void insertFirst(E elem) {
        Node<E> newNode = new Node<>(elem, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPreNode(newNode);
        }
        first = newNode;
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    @Override
    public E delete(int index) {
        Node<E> node = findNode(index);
        node.getPreNode().setNextNode(node.getNextNode());
        node.getNextNode().setPreNode(node.getPreNode());
        size--;
        reindex(node.getPreNode());
        return node.getContent();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = new Node<>(null, first);

            @Override
            public boolean hasNext() {
                return current.getNextNode() != null;
            }

            @Override
            public E next() {
                current = current.getNextNode();
                return (E) current.getValue();
            }
        };
    }
}
