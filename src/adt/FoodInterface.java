/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Jerry Chow
 */
public interface FoodInterface<T> {

    public boolean addFood(T food);

    public T getFood(int position);

    public T getNextFood();

    public void resetCursor();

    public boolean replaceFood(T food);

    public boolean removeFood(T food);
    
    public int getLength();

    public void swapPosition(int foodPosition1, int foodPosition2);
}
