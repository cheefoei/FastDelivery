/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author admin
 */
public class PunchCardList<T> implements PunchCardInterface {
    private Node firstNode;
    private int size;
    private int currentPosition;
    
    public PunchCardList() {
        this.firstNode = null;
        this.size = 0;
        this.currentPosition = 0;
    }

    
      public boolean addPunchCard(T newPC) {
        Node newNode = new Node(newPC);
         if (size() == 0) {
            firstNode = newNode;
        } else {
            Node referNode = firstNode;
            while (referNode.nextNode != null) {
                referNode = referNode.nextNode;
            }
            referNode.nextNode = newNode;
        }
        size++;
        return true;
    }
    public T getPC(int position) {

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
     public T goNext() {

        T data = getPC(currentPosition);
        currentPosition++;
        return data;
    }
     public boolean haveNext() {

        if (currentPosition >= size) {
            currentPosition = 0;
            return false;
        } else {
            return true;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
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
