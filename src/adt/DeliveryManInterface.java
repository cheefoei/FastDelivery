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
public interface DeliveryManInterface<T extends Comparable> extends BaseListInterface<T> {
    
    public boolean addByName(T deliveryMan);
    
    public boolean updateDeliveryMan(T deliveyMan, int position);
}
