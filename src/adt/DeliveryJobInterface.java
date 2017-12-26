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
public interface DeliveryJobInterface<T extends DeliveryJobComparable> extends BaseListInterface<T> {
    
    public void sortByTotalDelivery();
    
    public void sortByDeliveryTime();
}
