/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author cheefoei's
 * @param <T>
 */
public interface DeliveryJobInterface<T> {

    public boolean enqueueDeliveryJob(T deliveryJob);

    public T dequeueDeliveryJob();

    public T getFront();

    public int size();

    public boolean isEmpty();

    public boolean isContain(T deliveryJob);
}
