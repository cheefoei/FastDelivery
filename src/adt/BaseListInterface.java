/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Student
 * @param <T>
 */
public interface BaseListInterface<T> {

    public boolean add(T newData);

    public T get(int position);

    /* Use for iterating*/
    public T next();

    public boolean hasNext();

    public boolean isEmpty();

    public int size();

}
