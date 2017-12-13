/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Student
 */
public class HumanResourceList<T> implements StaffInterface<T> {

    private Node firstNode;
    private int size = 0;
    private int currentPosition = 0;

    public HumanResourceList() {
        this.firstNode = null;
    }

    @Override
    public boolean add(T newStaff) {

        Node newNode = new Node(newStaff);

        if (size() == 0) {
            firstNode = newNode;
            size++;
        } else {
            Node referNode = firstNode;
            while (referNode.nextNode != null) {
                referNode = referNode.nextNode;
            }
            referNode.nextNode = newNode;
            size++;
        }
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

    public T next() {

        currentPosition++;
        return get(currentPosition);
    }

    @Override
    public boolean hasNext() {

        if (currentPosition >= size) {
            currentPosition = 0;
            return false;
        } else {
            return currentPosition < size;
        }
    }

    @Override
    public boolean remove(T staff) {
        return true;
    }

    @Override
    public boolean remove(int position) {
        return true;
    }

    @Override
    public boolean replace(T staff, int position) {
        return true;
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

        public Node(T data) {
            this.data = data;
            this.nextNode = null;
        }
    }

}
