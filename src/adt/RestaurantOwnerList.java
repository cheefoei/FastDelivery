/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Jerry Chow
 * @param <T>
 */
public class RestaurantOwnerList<T> implements RestaurantOwnerInterface<T> {

    private Node node = null;
    private int length = 0;
    private int cursor = 0;

    public RestaurantOwnerList() {
    }

    @Override
    public boolean addRestOwner(T restOwner) {

        Node newNode = new Node(restOwner);
        if (isEmpty()) {
            node = newNode;
        } else {
            Node currentNode = node;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
        length++;
        return true;
    }

    @Override
    public T getRestOwner(int position) {

        T restOwner = null;
        if (position >= 0 && position < getLength()) {
            if (position == 0) {
                restOwner = node.entry;
            } else {
                Node currentNode = node;
                for (int i = 0; i < position; i++) {
                    currentNode = currentNode.nextNode;
                }
                restOwner = currentNode.entry;
            }
        }
        return restOwner;
    }

    @Override
    public T getCurrentRestOwner() {
        return getRestOwner(cursor - 1);
    }

    @Override
    public boolean moveToNext() {

        if (cursor < getLength()) {
            cursor++;
            return true;
        } else {
            resetCursor();
            return false;
        }
    }

    @Override
    public void resetCursor() {
        this.cursor = 0;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {

        int number = 1;
        String outputStr = "";
        Node currentNode = node;
        while (currentNode != null) {
            outputStr += number + "" + currentNode.entry + "\n";;
            currentNode = currentNode.nextNode;
            number++;
        }
        return outputStr;
    }

    private class Node {

        private T entry;
        private Node nextNode;

        private Node(T entry) {
            this.entry = entry;
            this.nextNode = null;
        }

        private Node(T entry, Node nextNode) {
            this.entry = entry;
            this.nextNode = nextNode;
        }
    }

}
