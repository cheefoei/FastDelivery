/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Clarity
 */
public class OrderDetails {
    
    private int foodId;
    private String foodName;
    private int foodPrice;
    private int orderId;
    private int qty;
    private int totalPrice;
    
    public OrderDetails(int foodId, String foodName,int foodPrice,int orderId,int qty,int totalPrice) {
        
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.orderId = orderId;
        this.orderId = orderId;
        this.qty = qty;
        this.totalPrice = totalPrice;
        
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
