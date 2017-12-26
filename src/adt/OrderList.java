/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Clarity
 * @param <T>
 */
public class OrderList<T extends Comparable<T>> implements OrderInterface<T> {

    private Node firstNode;
    private int length;

    @Override
    public boolean addNewOrder(T newEntry) {
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
    public int getOrderNo() {
        return length;
    }
    
    @Override
    public T getOrderAt(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }

    @Override
    public final void clear() {
        firstNode = null;
        length = 0;
    }

    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }
    
    @Override
    public boolean isEmpty() {
        return (length == 0);
    }

    @Override
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
