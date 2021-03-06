/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Clarity
 */
public class Orders implements Comparable<Orders> {

    private long orderId;
    private String status;
    private double totalPrice;
    private Date doneOrderDate;
    private Customer customer;

    public Orders() {
    }

    public Orders(String status, double totalPrice, Date doneOrderDate, Customer customer) {

        this.orderId = new Date().getTime();
        this.status = status;
        this.totalPrice = totalPrice;
        this.doneOrderDate = doneOrderDate;
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
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

    public Date getDoneOrderDate() {
        return doneOrderDate;
    }

    public void setDoneOrderDate(Date doneOrderDate) {
        this.doneOrderDate = doneOrderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @Override
    public String toString() {
        String orderID = "";
        if (orderId < 10) {
            orderID = "000" + orderId;
        } else if (orderId >= 10 && orderId < 100) {
            orderID = "00" + orderId;
        } else if (orderId >= 100 && orderId < 1000) {
            orderID = "0" + orderId;
        } else {
            orderID = "" + orderId;
        }
        return String.format("%-10s %-20s %-20s %-20s %-40s", "", orderID, status, totalPrice, doneOrderDate);
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
