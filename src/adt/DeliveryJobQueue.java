/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author cheefoei's
 * @param <T>
 */
public class DeliveryJobQueue<T> implements DeliveryJobInterface<T> {

    private Node firstNode;
    private int length;

    public DeliveryJobQueue() {
        this.length = 0;
    }

    @Override
    public void enqueueDeliveryJob(T deliveryJob) {

        if (isEmpty()) {
            firstNode = new Node(deliveryJob);
        } else {
            Node referNode = firstNode;
            while (referNode.nextNode != null) {
                referNode = referNode.nextNode;
            }
            referNode.nextNode = new Node(deliveryJob);
        }
        length++;
    }

    @Override
    public T dequeueDeliveryJob() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getFront() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isContain(T deliveryJob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAll() {

        this.firstNode = null;
        this.length = 0;
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
