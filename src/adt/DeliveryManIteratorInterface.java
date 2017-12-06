/*
 Created by: Leong Chee Foei
*/
package adt;

import java.util.Iterator;

public interface DeliveryManIteratorInterface<T> extends DeliveryManInterface<T>{
    
    public Iterator getIterator();
}
