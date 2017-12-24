/*
 Created by: Leong Chee Foei
 */
package adt;

public class DeliveryManList<T extends Comparable> implements DeliveryManInterface<T> {

    private Node firstNode;
    private int size = 0;
    private int currentPosition = 0;

    public DeliveryManList() {
        this.firstNode = null;
    }

    @Override
    public boolean add(T newDeliveryMan) {

        Node newNode = new Node(newDeliveryMan);
        Node currentNode = firstNode;
        Node beforeNode = null;

        while (currentNode != null && newDeliveryMan.compareTo(currentNode.data) > 0) {
            beforeNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        if (isEmpty() || beforeNode == null) {
            newNode.nextNode = firstNode;
            this.firstNode = newNode;
        } else {
            newNode.nextNode = currentNode;
            beforeNode.nextNode = newNode;
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
                throw new IndexOutOfBoundsException();
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
    public boolean remove(T deliveyMan) {

        boolean isRemoved = false;

        if (!isEmpty()) {
            Node referNode = firstNode;
            for (int i = 0; i < size; i++) {
                if (referNode.data != deliveyMan) {

                }
                referNode = referNode.nextNode;
            }
            size--;
        }
        return isRemoved;
    }

    @Override
    public boolean remove(int position) {
        return true;
    }

    @Override
    public boolean replace(T deliveyMan, int position) {

        boolean isReplaced = false;
        if (!isEmpty()) {
            if (position < size) {
                if (position == 0) {
                    firstNode.data = deliveyMan;
                } else {
                    Node referNode = firstNode;
                    for (int i = 0; i < position; i++) {
                        referNode = referNode.nextNode;
                    }
                    referNode.data = deliveyMan;
                }
                isReplaced = true;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return isReplaced;
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

        private Node(T data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }

}
