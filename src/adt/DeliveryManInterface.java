/*
 Created by: Leong Chee Foei
 */
package adt;

public interface DeliveryManInterface<T extends Comparable> extends BasicListInterface<T> {

    public void sortByName(String mode);

    public void sortByStatus();
}
