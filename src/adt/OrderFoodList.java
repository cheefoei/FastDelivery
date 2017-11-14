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
public class OrderFoodList <T extends Comparable<? super T>> implements OrderFoodInterface<T>{
    
    private Node firstNode;
    private int length;
    
    public OrderFoodList() {
        clear();
    }
    public final void clear() {
        firstNode = null;
        length = 0;
    }

    @Override
    public boolean addNewOrder(T newOrder) {
        Node newNode = new Node(newOrder);

        Node nodeBefore = null;
        Node currentNode = firstNode;
        while (currentNode != null && newOrder.compareTo(currentNode.data) > 0) {
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
    public boolean isEmpty() {
        return (length == 0);
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
