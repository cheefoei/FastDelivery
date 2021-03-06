/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Student
 * @param <T>
 */
public class BaseList<T> implements BaseListInterface<T> {

    private Node firstNode;
    private int size;
    private int currentPosition;

    public BaseList() {
        this.firstNode = null;
        this.size = 0;
        this.currentPosition = 0;
    }

    @Override
    public boolean add(T newData) {

        Node newNode = new Node(newData);
        if (size() == 0) {
            firstNode = newNode;
        } else {
            Node referNode = firstNode;
            while (referNode.nextNode != null) {
                referNode = referNode.nextNode;
            }
            referNode.nextNode = newNode;
        }
        size++;
        return true;
    }

    @Override
    public T get(int position) {

        T data = null;
        if (!isEmpty()) {
            if (position < size) {
                Node referNode = firstNode;
                for (int i = 0; i <= position; i++) {
                    data = referNode.data;
                    referNode = referNode.nextNode;
                }
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        return data;
    }

    @Override
    public T next() {

        T data = get(currentPosition);
        currentPosition++;
        return data;
    }

    @Override
    public boolean hasNext() {

        if (currentPosition >= size) {
            currentPosition = 0;
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {

        private T data;
        private Node nextNode;

        private Node(T data) {
            this.data = data;
            this.nextNode = null;
        }
    }

}
