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
public class OrderFoodList<T> implements OrderFoodInterface<T> {

    private Node firstNode = null;
    private int length = 0;
    private int cursor = 0;

    public OrderFoodList() {
    }

    @Override
    public boolean addNewOrder(T newEntry) {

        Node newNode = new Node(newEntry);
        if (getOrderNo() == 0) {
            firstNode = newNode;
        } else {
            Node referNode = firstNode;
            while (referNode.next != null) {
                referNode = referNode.next;
            }
            referNode.next = newNode;
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
        if ((givenPosition >= 0) && (givenPosition < length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition; i++) {
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

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public void reset() {
        this.cursor = 0;
    }

    @Override
    public boolean goToNext() {

        if (cursor < getOrderNo()) {
            cursor++;
            return true;
        } else {
            reset();
            return false;
        }
    }

    @Override
    public T getCurrentOrderDetail() {
        return getOrderAt(cursor - 1);
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
