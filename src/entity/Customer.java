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
public class Customer implements Serializable {

    private String cusName;
    private String cusIc;
    private String cusGender;
    Contact contact;
    public String cusUsername;
    public String cusPw;
    
        public Customer(String cusName, String cusIc, String cusGender, Contact contact, String cusUsername, String cusPw) {
        this.cusName = cusName;
        this.cusIc = cusIc;
        this.cusGender = cusGender;
        this.contact = contact;
        this.cusUsername = cusUsername;
        this.cusPw = cusPw;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusIc() {
        return cusIc;
    }

    public void setCusIc(String cusIc) {
        this.cusIc = cusIc;
    }

    public String getCusGender() {
        return cusGender;
    }

    public void setCusGender(String cusGender) {
        this.cusGender = cusGender;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getCusUsername() {
        return cusUsername;
    }

    public void setCusUsername(String cusUsername) {
        this.cusUsername = cusUsername;
    }

    public String getCusPw() {
        return cusPw;
    }

    public void setCusPw(String cusPw) {
        this.cusPw = cusPw;
    }

    

    
    //    @Override
//    public String toString() {
//        return String.format("%-20s %-6s %-18s %-10s %-25s %-20s %-10s",cusName,cusIc,cusGender,cusAddress,cusContactNo,cusEmail); //To change body of generated methods, choose Tools | Templates.
//    }
}
