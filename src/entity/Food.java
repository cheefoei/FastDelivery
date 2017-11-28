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
public class Food implements Serializable {

    private String foodName;
    private double foodPrice;
    private String foodDesc;
    private RestaurantOwner restaurant;

    public Food() {
    }

    public Food(String foodName, double foodPrice, String foodDesc, RestaurantOwner restaurant) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDesc = foodDesc;
        this.restaurant = restaurant;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public RestaurantOwner getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantOwner restaurant) {
        this.restaurant = restaurant;
    }
}
