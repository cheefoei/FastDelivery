/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Clarity
 */
public class Orders implements Comparable<Orders> {
    
    private int orderId;
    private String status;
    private double totalPrice;
    
    public Orders(int orderId, String status, double totalPrice) {
        this.orderId = orderId;
        this.status = status;
        this.totalPrice = totalPrice;
        
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    @Override
     public String toString() {
    String orderID ="";
        if(orderId<10){
        orderID = "000"+ orderId;
        }else if(orderId >=10 && orderId < 100){
            orderID = "00"+orderId;
        }else if(orderId >=100 && orderId < 1000){
            orderID = "0"+orderId;
        }else{
            orderID = ""+orderId;
        }
        return String.format("%-10s %-20s %-20s %-20s", "", orderID, status, totalPrice);
     }
    @Override
    public int compareTo(Orders orders) {
        if (orderId > orders.getOrderId()) {
            return 1;
        } else if (orderId == orders.getOrderId()) {
            return 0;
        } else {
            return -1;
        }
    }
}
