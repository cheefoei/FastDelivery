/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author cheefoei's
 */
public class DeliveryJob implements Serializable, Comparable<DeliveryJob> {

    private Orders order;
    private DeliveryMan deliveryMan;
    private double deliveryFee;
    private double distance;
    private Date deliveryDate;
    private boolean isDone;

    public DeliveryJob() {
    }

    public DeliveryJob(Orders order, DeliveryMan deliveryMan, double distance) {

        Calendar now = Calendar.getInstance();

        this.order = order;
        this.deliveryMan = deliveryMan;
        this.deliveryFee = calculateDeliveryFee();
        this.distance = distance;
        this.deliveryDate = now.getTime();
        this.isDone = false;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    private double calculateDeliveryFee() {

        // If purchase order more than RM20 then no delivery fee
        if (order.getTotalPrice() > 20) {
            return 0;
        } else {
            return 5;
        }
    }

    @Override
    public int compareTo(DeliveryJob o) {
        return 0;
    }
}
