/*
 Created by: Leong Chee Foei
 */
package adt;

public interface DeliveryManInterface<T> {

    public boolean addDeliveryMan(T newData);

    public boolean addDeliveryMan(T newData, int position);

    public T getDeliveryMan(int position);

    public boolean replace(T newData, int position);

    public int getDeliveryManSize();

    public void remove(T deliveryMan);

    public void remove(int position);

    public void removeAll();

    public DeliveryManInterface getNameSorted();

    public DeliveryManInterface getStatusSorted();
}
