/*
 Created by: Leong Chee Foei
 */
package adt;

public class DeliveryManList<T> implements DeliveryManInterface<T> {

    private Node firstNode;
    private int size = 0;
    private int currentPosition = 0;

    public DeliveryManList() {
        this.firstNode = null;
    }

    @Override
    public boolean add(T newStaff) {

        Node newNode = new Node(newStaff);

        if (size() == 0) {
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
    public boolean remove(T staff) {

        boolean isRemoved = false;

        if (!isEmpty()) {
            Node referNode = firstNode;
            for (int i = 0; i < size; i++) {
                if (referNode.data != staff) {

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
    public boolean replace(T staff, int position) {

        boolean isReplaced = false;
        if (!isEmpty()) {
            if (position < size) {
                if (position == 0) {
                    firstNode.data = staff;
                } else {
                    Node referNode = firstNode;
                    for (int i = 0; i <= position; i++) {
                        if (i == position) {
                            referNode.data = staff;
                        }
                        referNode = referNode.nextNode;
                    }
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
    public DeliveryManInterface getNameSorted() {
        return null;
    }

    @Override
    public DeliveryManInterface getStatusSorted() {
        return null;
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
