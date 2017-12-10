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
 * @author Clarity
 */
public class Payment implements Serializable {

    private int paymentId;
    private Date paymentDate;
    private Orders order;
    private int totalPrice;

    public Payment(int paymentId, Date paymentDate, Orders order, int totalPrice) {

        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.order = order;
        this.totalPrice = totalPrice;

    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrderId(Orders order) {
        this.order = order;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
