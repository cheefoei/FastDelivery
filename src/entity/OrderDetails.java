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
public class OrderDetails implements Serializable, Comparable<OrderDetails> {

    private Orders order;
    private Food food;
    private int qty;
    private String remark; //Let customer to remark no egg? no spicy?

    public OrderDetails() {
    }

    public OrderDetails(Orders order, Food food, int qty, String remark) {
        this.order = order;
        this.food = food;
        this.qty = qty;
        this.remark = remark;
    }
    
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Override
    public String toString() {
        String orderID = "";
        if (order.getOrderId() < 10) {
            orderID = "000" + order.getOrderId();
        } else if (order.getOrderId() >= 10 && order.getOrderId() < 100) {
            orderID = "00" + order.getOrderId();
        } else if (order.getOrderId() >= 100 && order.getOrderId() < 1000) {
            orderID = "0" + order.getOrderId();
        } else {
            orderID = "" + order.getOrderId();
        }
        return String.format("%-10s %-20s %-20s %-20s %-20s", "", order.getOrderId(), food.getFoodName(), qty, remark);
    }
    
    @Override
    public int compareTo(OrderDetails od) {
        
        if (qty > od.getQty()) {
            return 1;
        } else if (qty == od.getQty()) {
            return 0;
        } else {
            return -1;
        }
        
        
    }
    
    


    
}
