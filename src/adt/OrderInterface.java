/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Clarity
 * @param <T>
 */
public interface OrderInterface <T>{
    
    public boolean addNewOrder(T newOrder); // Add new order
    
    public T getOrderAt(int givenPosition); // Retrieve order at specific position
    
    public int getOrderNo(); // Retrieve total number of orders
    
    public boolean goToNext();

    public void reset();
    
    public T getCurrentOrder();
    
    public void clear(); // Clear all records
    
    public boolean isEmpty(); // Check whether the records is empty or not
}
