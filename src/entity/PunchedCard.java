/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */
public class PunchedCard implements Serializable {

    private String punched_status;
    private Date clock_in;
    private Date clock_out;
    private DeliveryMan deliveryMan;

    public PunchedCard() {
    }

    public PunchedCard(String punched_status, Date clock_in, Date clock_out, DeliveryMan deliveryMan) {

        this.punched_status = punched_status;
        this.clock_in = clock_in;
        this.clock_out = clock_out;
        this.deliveryMan = deliveryMan;
    }

    public String getPunched_status() {
        return punched_status;
    }

    public void setPunched_status(String punched_status) {
        this.punched_status = punched_status;
    }

    public Date getClock_in() {
        return clock_in;
    }

    public void setClock_in(Date clock_in) {
        this.clock_in = clock_in;
    }

    public Date getClock_out() {
        return clock_out;
    }

    public void setClock_out(Date clock_out) {
        this.clock_out = clock_out;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }
}
