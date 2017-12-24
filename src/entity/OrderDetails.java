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
public class OrderDetails implements Serializable {

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
    
    


    
}
