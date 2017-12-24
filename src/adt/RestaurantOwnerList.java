/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Clarity
 */
public class RestaurantOwnerList<T> implements RestaurantOwnerInterface<T> {
    
    private Node firstNode;
    private int length;
    
    public RestaurantOwnerList() {
        clear();
    }

    @Override
    public boolean add(T newEntry) {

        Node newNode = new Node(newEntry);
        if (getLength() == 0) {
            firstNode = newNode;
            length++;
        } else {
            Node referNode = firstNode;
            while (referNode.next != null) {
                referNode = referNode.next;
            }
            referNode.next= newNode;
            length++;
        }
        return true;
    }

    
    @Override
    public int getLength() {
        return length;
    }
    
    @Override
    public final void clear() {
        firstNode = null;
        length = 0;
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
    
    @Override
    public T getAt(int givenPosition) {
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
