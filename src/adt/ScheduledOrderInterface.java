/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Lee Zi Xiang
 */
public interface ScheduledOrderInterface<T extends Comparable<? super T>> {

    public boolean add(T newEntry);

    public T remove(int position);

    public T show(int position);

    public void clear();

    public int size();

    public boolean isEmpty();

    public boolean replace(int position, T entry);
}
