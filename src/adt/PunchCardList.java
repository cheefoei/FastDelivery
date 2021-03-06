/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author admin
 * @param <T>
 */
public class PunchCardList<T> implements PunchCardInterface<T> {

    private Node firstNode;
    private int size;
    private int currentPosition;

    public PunchCardList() {
        this.firstNode = null;
        this.size = 0;
        this.currentPosition = 0;
    }

    @Override
    public boolean addPunchCard(T newPc) {

        Node newNode = new Node(newPc);
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
    public T getPunchCard(int position) {

        T data = null;
        if (!isEmpty()) {
            if (position < size) {
                Node referNode = firstNode;
                for (int i = 0; i <= position; i++) {
                    data = referNode.entry;
                    referNode = referNode.nextNode;
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return data;
    }

    @Override
    public T goNext() {

        T data = getPunchCard(currentPosition);
        currentPosition++;
        return data;
    }

    @Override
    public boolean haveNext() {

        if (currentPosition >= size) {
            currentPosition = 0;
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean updatePunchCard(int position, T newCard) {

        boolean isUpdated = false;
        if (!isEmpty()) {
            if (position < size) {
                if (position != 0) {
                    Node node = firstNode;
                    for (int i = 0; i < position; i++) {
                        node = node.nextNode;
                    }
                    node.entry = newCard;
                } else {
                    firstNode.entry = newCard;
                }
                isUpdated = true;
            }
        }
        return isUpdated;
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

        private T entry;
        private Node nextNode;

        private Node(T entry) {
            this.entry = entry;
            this.nextNode = null;
        }
    }
}
