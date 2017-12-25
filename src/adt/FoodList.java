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
public class FoodList<T> implements FoodInterface<T> {

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
            } else if (getLength() > 1) {
                Node currentNode = node;
                for (int i = 1; i < position; i++) {
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
    public boolean replaceFood(T food) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFood(T food) {

        if (getLength() == 0) {
            return false;
        } else {
            boolean isFound = false;
            Node currentNode = node;
            while (!isFound && currentNode.nextNode != null) {
                if (currentNode.entry == food) {
                    isFound = true;
                } else {
                    currentNode = currentNode.nextNode;
                }
            }
            currentNode = currentNode.nextNode;
            return true;
        }
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void swapPosition(int foodPosition1, int foodPosition2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Node {

        private T entry;
        private Node nextNode;

        public Node(T entry) {
            this.entry = entry;
            this.nextNode = null;
        }
    }
}
