/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author cheefoei's
 */
public class DeliveryJob implements Serializable, Comparable<DeliveryJob> {

    private DeliveryMan deliveryMan;
    private Date deliveryJobDate;
    private double totalDistance;
    private int totalDelivery;

    public DeliveryJob() {
    }

    public DeliveryJob(DeliveryMan deliveryMan, Date deliveryJobDate, double totalDistance, int totalDelivery) {
        this.deliveryMan = deliveryMan;
        this.deliveryJobDate = deliveryJobDate;
        this.totalDistance = totalDistance;
        this.totalDelivery = totalDelivery;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Date getDeliveryJobDate() {
        return deliveryJobDate;
    }

    public void setDeliveryJobDate(Date deliveryJobDate) {
        this.deliveryJobDate = deliveryJobDate;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getTotalDelivery() {
        return totalDelivery;
    }

    public void setTotalDelivery(int totalDelivery) {
        this.totalDelivery = totalDelivery;
    }

    public void addToDistance(double distance) {
        this.totalDistance += distance;
    }

    public void increaseDelivery() {
        this.totalDelivery++;
    }

    @Override
    public int compareTo(DeliveryJob o) {

        return Comparator.comparing(DeliveryJob::getTotalDelivery)
                .thenComparing(DeliveryJob::getTotalDistance)
                .compare(o, this);

    }
}
