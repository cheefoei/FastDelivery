/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.DeliveryJobComparable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cheefoei's
 */
public class DeliveryJob implements Serializable, DeliveryJobComparable<DeliveryJob> {

    private DeliveryMan deliveryMan;
    private Date deliveryStartTime;
    private Date deliveryEndTime;
    private double totalDistance;
    private int totalDelivery;
    private boolean isDelivered;

    public DeliveryJob() {
    }

    public DeliveryJob(
            DeliveryMan deliveryMan,
            Date deliveryStartTime,
            Date deliveryEndTime,
            double totalDistance,
            int totalDelivery) {

        this.deliveryMan = deliveryMan;
        this.deliveryStartTime = deliveryStartTime;
        this.deliveryEndTime = deliveryEndTime;
        this.totalDistance = totalDistance;
        this.totalDelivery = totalDelivery;
        this.isDelivered = false;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Date getDeliveryStartTime() {
        return deliveryStartTime;
    }

    public void setDeliveryStartTime(Date deliveryStartTime) {
        this.deliveryStartTime = deliveryStartTime;
    }

    public Date getDeliveryEndTime() {
        return deliveryEndTime;
    }

    public void setDeliveryEndTime(Date deliveryEndTime) {
        this.deliveryEndTime = deliveryEndTime;
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

    public boolean isIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public long getTimeDiff() {
        return getDeliveryEndTime().getTime() - getDeliveryStartTime().getTime();
    }

    public void increTotalDelivery() {
        this.totalDelivery++;
    }

    @Override
    public int compareToTotalDelivery(DeliveryJob o) {
        return Integer.compare(this.totalDelivery, o.getTotalDelivery());
    }

    @Override
    public int compareToDeliveryTime(DeliveryJob o) {
        return Long.compare(this.getTimeDiff(), o.getTimeDiff());
    }

}
