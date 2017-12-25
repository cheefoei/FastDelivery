/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Clarity
 */
public interface RestaurantOwnerInterface<T> {

    public boolean addRestOwner(T newRestOwner);

    public T getRestOwner(int position);

    public T getNextRestOwner();

    public void resetCursor();

    public int getLength();

    public boolean isEmpty();

}
