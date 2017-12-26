/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author cheefoei's
 */
public class DeliveryOrder implements Serializable {

    private DeliveryJob deliveryJob;
    private Orders order;
    private double deliveryFee;
    private double distance;
    private Date deliveryDate;
    private boolean isDone;

    public DeliveryOrder(
            DeliveryJob deliveryJob,
            Orders order) {

        Calendar now = Calendar.getInstance();

        this.deliveryJob = deliveryJob;
        this.order = order;
        this.deliveryFee = calculateDeliveryFee();
        this.deliveryDate = now.getTime();
        this.distance = (1.0 + (5.0 - 1.0) * new Random().nextDouble());
        this.isDone = false;
    }

    public DeliveryOrder(
            DeliveryJob deliveryJob,
            Orders order,
            double distance) {

        Calendar now = Calendar.getInstance();

        this.deliveryJob = deliveryJob;
        this.order = order;
        this.deliveryFee = calculateDeliveryFee();
        this.distance = distance;
        this.deliveryDate = now.getTime();
        this.isDone = false;
    }

    public DeliveryJob getDeliveryJob() {
        return deliveryJob;
    }

    public void setDeliveryJob(DeliveryJob deliveryJob) {
        this.deliveryJob = deliveryJob;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
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
}
