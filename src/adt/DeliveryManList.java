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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T next() {

        T data = null;
        if (hasNext()) {
            data = get(currentPosition);
            currentPosition++;
        }
        System.out.println("next");

        return data;
    }

    @Override
    public boolean hasNext() {

        if (currentPosition >= size) {
            currentPosition = 0;
        }
        System.out.println("hasnext");
        return currentPosition < size;
    }

    @Override
    public boolean remove(T staff) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean replace(T staff, int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
