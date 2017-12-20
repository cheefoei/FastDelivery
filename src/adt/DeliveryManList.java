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

        if (size() == 0) {
            firstNode = newNode;
            size++;
        } else {
            Node travelNode = firstNode;
            while (travelNode.nextNode != null) {
                travelNode = travelNode.nextNode;
            }
            newNode.prevNode = travelNode;
            travelNode.nextNode = newNode;
            size++;
        }
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

    @Override
    public void sortByNameDesc() {

        Node sortedNode = firstNode;
        int index = 0;
        char currentChar;

        for (int i = 0; i < size; i++) {
            
            entity.DeliveryMan dm = (entity.DeliveryMan) sortedNode.data;
            String name = dm.fname + dm.lname;
            char c = name.charAt(index);
            
        }
    }

    @Override
    public void sortByStatus() {
    }

    private class Node {

        private T data;
        private Node prevNode;
        private Node nextNode;

        public Node(T data) {
            this.data = data;
            this.prevNode = null;
            this.nextNode = null;
        }
    }

}
