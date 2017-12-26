/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author admin
 * @param <T>
 */
public interface PunchCardInterface<T> {

    public boolean addPunchCard(T newPc);

    public T getPunchCard(int position);

    public T goNext();

    public boolean haveNext();

    public boolean isEmpty();

    public int size();
}
