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
public class FoodList<T extends Comparable> implements FoodInterface<T> {

    private Node node = null;
    private int length = 0;
    private int cursor = 0;

    public FoodList() {
    }

    @Override
    public boolean addFood(T food) {

        Node newNode = new Node(food);
        if (getLength() == 0) {
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
    public T getFood(int position) {

        T food = null;
        if (position >= 0 && position < getLength()) {
            if (position == 0) {
                food = node.entry;
            } else {
                Node currentNode = node;
                for (int i = 0; i < position; i++) {
                    currentNode = currentNode.nextNode;
                }
                food = currentNode.entry;
            }
        }
        return food;
    }

    @Override
    public T getCurrentFood() {
        return getFood(cursor - 1);
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
    public boolean updateFood(T oldFood, T newFood) {

        if (getLength() == 0) {
            return false;
        } else {
            this.node = replace(oldFood, newFood, node);
            return true;
        }
    }

    private Node replace(T oldEntry, T newEntry, Node currentNode) {

        if (oldEntry.equals(currentNode.entry)) {
            currentNode.entry = newEntry;
        } else {
            Node nodeAfter = replace(oldEntry, newEntry, currentNode.nextNode);
            currentNode.nextNode = nodeAfter;
        }

        return currentNode;
    }

    @Override
    public boolean removeFood(T food) {

        if (getLength() == 0) {
            return false;
        } else {
            this.node = remove(food, node);
            length--;
            return true;
        }
    }

    private Node remove(T entry, Node currentNode) {

        if (entry.equals(currentNode.entry)) {
            currentNode = currentNode.nextNode;
        } else {
            Node nodeAfter = remove(entry, currentNode.nextNode);
            currentNode.nextNode = nodeAfter;
        }

        return currentNode;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void arrangeFood(int foodPosition, T food) {

        if (foodPosition >= 0 && foodPosition < getLength()) {

            Node currentNode = node;
            for (int i = 0; i < foodPosition; i++) {
                currentNode = currentNode.nextNode;
            }
            currentNode.entry = food;
        }
    }

    @Override
    public void sortByPopular() {

    }

    private class Node {

        private T entry;
        private Node nextNode;

        public Node(T entry) {
            this.entry = entry;
            this.nextNode = null;
        }

        public Node(T entry, Node nextNode) {
            this.entry = entry;
            this.nextNode = nextNode;
        }
    }
}
