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
public class OrderDetails implements Comparable<OrderDetails> {
    
    public static double subTotal;
public static double runningTotal;
private static double itemPrice;
    private String foodName;
    private double foodPrice;
    private int orderId;
    private int qty;
    private double totalPrice;
    private int foodId;
    
    public OrderDetails(int foodId, int qty) {
        
        this.foodId = foodId;
        //this.foodName = foodName;
        //this.foodPrice = foodPrice;
        //this.orderId = orderId;
        this.qty = qty;
        //this.totalPrice = totalPrice;
        
    }

    public double getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    
    
public String toString(){
    
        String s;
        if(foodId == 1){
            s = "Char Kuey Teow";
        }else if(foodId == 2){
            s = "Chicken Rice";
        }else if(foodId == 3){
            s = "Fish head noodles";
        }else if(foodId == 4){
            s = "Fried Rice";
        }else if(foodId == 5){
            s = "Tose";
        }else if(foodId == 6){
            s = "Roti Telur";
        }else if(foodId == 7){
            s = "Cheese Naan";
        }else if(foodId == 8){
            s = "Banana Leaf Rice";
        }else if(foodId == 9){
            s = "Nasi Lemak";
        }else if(foodId == 10){
            s = "Asam Laksa";
        }else if(foodId == 11){
            s = "Ayam Penyet";
        }else {
            s = "Murtabak";
        }
        
        
       return String.format("%-10s %-20s %-20s","",s,qty);
}

@Override
    public int compareTo(OrderDetails orderdetails) {
        if (foodId > orderdetails.getFoodId()) {
            return 1;
        } else if (foodId == orderdetails.getFoodId()) {
            return 0;
        } else {
            return -1;
        }
    }
}