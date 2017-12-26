/*
 Created by: Leong Chee Foei
 */
package adt;

public class DeliveryJobList<T extends DeliveryJobComparable> implements DeliveryJobInterface<T> {

    private Node firstNode;
    private int size;
    private int currentPosition;

    public DeliveryJobList() {
        this.firstNode = null;
        this.size = 0;
        this.currentPosition = 0;
    }

    @Override
    public boolean add(T deliveryMan) {

        Node newNode = new Node(deliveryMan);
        if (size() == 0) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
        size++;
        return true;
    }

    @Override
    public T get(int position) {

        T data = null;
        if (!isEmpty()) {
            if (position < size) {
                Node currentNode = firstNode;
                for (int i = 0; i <= position; i++) {
                    data = currentNode.data;
                    currentNode = currentNode.nextNode;
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
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sortByTotalDelivery() {

        Node sortedNode = null;
        while (hasNext()) {
            sortedNode = sortingTotalDelivery(next(), sortedNode);
        }
        this.firstNode = sortedNode;
    }

    private Node sortingTotalDelivery(T job, Node currentNode) {

        if (currentNode == null || job.compareToTotalDelivery(currentNode.data) > 0) {
            currentNode = new Node(job, currentNode);
        } else {
            Node afterNode = sortingTotalDelivery(job, currentNode.nextNode);
            currentNode.nextNode = afterNode;
        }
        return currentNode;
    }

    @Override
    public void sortByDeliveryTime() {

        Node sortedNode = null;
        while (hasNext()) {
            sortedNode = sortingDeliveryTime(next(), sortedNode);
        }
        this.firstNode = sortedNode;
    }

    private Node sortingDeliveryTime(T job, Node currentNode) {

        if (currentNode == null || job.compareToDeliveryTime(currentNode.data) > 0) {
            currentNode = new Node(job, currentNode);
        } else {
            Node afterNode = sortingDeliveryTime(job, currentNode.nextNode);
            currentNode.nextNode = afterNode;
        }
        return currentNode;
    }

    private class Node {

        private T data;
        private Node nextNode;

        private Node(T data) {
            this.data = data;
            this.nextNode = null;
        }

        public Node(T data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

    }

}
