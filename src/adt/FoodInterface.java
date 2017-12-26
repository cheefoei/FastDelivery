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
public interface FoodInterface<T extends Comparable> {

    public boolean addFood(T food);

    public T getFood(int position);

    public T getCurrentFood();

    public boolean moveToNext();

    public void resetCursor();

    public boolean updateFood(T oldFood, T newFood);

    public boolean removeFood(T food);

    public int getLength();

    public void swapPosition(int foodPosition1, int foodPosition2);

    public void sortByPopular();
}