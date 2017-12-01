/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lee Zi Xiang
 */
public class ScheduledOrder implements Comparable<ScheduledOrder> {

    private int orderId;
    private String status;
    private double totalPrice;
    private Date scheduleDate;
    private Date scheduleTime;

    public ScheduledOrder(int orderId, String status, double totalPrice, Date scheduleDate, Date scheduleTime) {
        this.orderId = orderId;
        this.status = status;
        this.totalPrice = totalPrice;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public String toString() {
        String orderID = "";
        if (orderId < 10) {
            orderID = "000" + orderId;
        } else if (orderId >= 10 && orderId < 100) {
            orderID = "00" + orderId;
        } else if (orderId >= 100 && orderId < 1000) {
            orderID = "0" + orderId;
        } else {
            orderID = "" + orderId;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");

        return String.format("%-10s %-20s %-20s %-20s %-20s %-20s", "", orderID, status, totalPrice, dateFormat.format(scheduleDate), timeFormat.format(scheduleTime));
    }

    @Override
    public int compareTo(ScheduledOrder o) {
        if (orderId > o.getOrderId()) {
            return 1;
        } else if (orderId == o.getOrderId()) {
            return 0;
        } else {
            return -1;
        }
    }

}
