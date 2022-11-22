package com.example.lesson_2;

public class Node <E>{
    private int index;
    private E content;
    private Node<E> nextNode;
    private Node<E> preNode;
    E value;

    public Node(int index, E content) {
        this.index = index;
        this.content = content;
    }

    public <E> Node(Object o, Node<E> first) {
    }

    public <E> Node(Node<E> current, E elem, Node<E> nextNode) {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E getContent() {
        return content;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<E> getPreNode() {
        return preNode;
    }

    public void setPreNode(Node<E> preNode) {
        this.preNode = preNode;
    }

    public E getValue() {
        return value;
    }
}
