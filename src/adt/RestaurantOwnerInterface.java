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
public interface RestaurantOwnerInterface <T> {
    
    public boolean add(T newEntry); // Add new records
    
    public T getAt(int givenPosition);
    
    public int getLength();
    
    public void clear(); // Clear all records
    
    public boolean isEmpty(); // Check whether the records is empty or not
    
}
