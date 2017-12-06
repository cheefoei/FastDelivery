/*
 Created by: Leong Chee Foei
 */
package adt;

import java.util.Iterator;

public class DeliveryManList<T> implements DeliveryManIteratorInterface<T> {

    private Node firstNode;
    private int size = 0;

    public DeliveryManList() {
        this.firstNode = null;
    }

    @Override
    public boolean addDeliveryMan(T newData) {

        Node newNode = new Node(newData);

        if (getDeliveryManSize() == 0) {
            firstNode = newNode;
            size++;
        } else {
            Node travelNode = firstNode;
            while (travelNode.nextNode != null) {
                travelNode = travelNode.nextNode;
            }
            travelNode.nextNode = newNode;
            size++;
        }
        return false;
    }

    @Override
    public boolean addDeliveryMan(T newData, int position) {
        return false;
    }

    @Override
    public T getDeliveryMan(int position) {
        return null;
    }

    @Override
    public boolean replace(T newData, int position) {
        return false;
    }

    @Override
    public void remove(T deliveryMan) {
    }

    @Override
    public void remove(int position) {
    }

    @Override
    public void removeAll() {

        this.firstNode = null;
        this.size = 0;
    }

    @Override
    public int getDeliveryManSize() {
        return size;
    }

    @Override
    public DeliveryManInterface getNameSorted() {
        return null;
    }

    @Override
    public DeliveryManInterface getStatusSorted() {
        return null;
    }

    @Override
    public Iterator getIterator() {
        return new DeliveryManIterator();
    }

    private class DeliveryManIterator implements Iterator<T> {

        private Node currentNode = firstNode;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {

            T data = null;
            if (hasNext()) {
                data = currentNode.data;
                currentNode = currentNode.nextNode;
            }

            return data;
        }

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
