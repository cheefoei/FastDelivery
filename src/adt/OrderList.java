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
public class OrderList<T extends Comparable<? super T>> implements OrderInterface<T> {

    private Node firstNode;
    private int length;

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

    public final void clear() {
        firstNode = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return (length == 0);
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

    }

}
