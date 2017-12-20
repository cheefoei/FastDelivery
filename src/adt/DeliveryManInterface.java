/*
 Created by: Leong Chee Foei
 */
package adt;

import entity.DeliveryMan;

public interface DeliveryManInterface<T> extends BasicListInterface<T> {

    public void sortByNameDesc();

    public void sortByStatus();
}
