/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.ScheduledOrder;

/**
 *
 * @author Lee Zi Xiang
 */
public class ScheduledOrderList <T extends Comparable<? super T>> implements ScheduledOrderInterface<T> {

    private Node firstNode;
    private int length;

    public ScheduledOrderList() {
        clear();
    }

    //Add with priority
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        Node nodeBefore = null;
        Node currentNode = firstNode;
        while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        }

        if (isEmpty() || (nodeBefore == null)) {
            newNode.next = firstNode;
            firstNode = newNode;
        } else {
            newNode.next = currentNode;
            nodeBefore.next = newNode;
        }
        length++;
        return true;
    }

    @Override
    public T remove(int position) {
        T result = null;

        if ((position >= 1) && (position <= length)) {
            if (position == 1) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < position - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            } 																// one to be deleted (to disconnect node from chain)
            length--;
        }
        return result;
    }

    @Override
    public T show(int position) {
        T result = null;

        if ((position >= 1) && (position <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < position - 1; ++i) {
                currentNode = currentNode.next;

            }
            result = currentNode.data;

        }

        return result;
    }

    public boolean replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {

                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        } else {
            return false;
        }

        return true;
    }

    @Override
    public void clear() {
        firstNode = null;
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    public String toString() {
        int number = 1;
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += number + "" + currentNode.data + "\n";;
            currentNode = currentNode.next;
            number++;
        }
        return outputStr;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;

        }

    }

}
