/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Student
 */
public interface StaffInterface<T> {

    public boolean add(T newStaff);

    public T get(int position);
    
    public T next();

    public boolean hasNext();

    public boolean remove(T staff);

    public boolean remove(int position);

    public boolean replace(T staff, int position);

    public boolean isEmpty();

    public int size();
}
