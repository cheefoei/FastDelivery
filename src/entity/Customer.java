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
    private String cusAddress;
    private String cusContactNo;
    private String cusEmail;
    public String cusUsername;
    public String cusPw;

    public Customer(String cusName, String cusIc,String cusGender,String cusAddress,String cusContactNo,String cusEmail,String cusUsername,String cusPw) {
        this.cusName = cusName;
        this.cusIc = cusIc;
        this.cusGender = cusGender;
        this.cusAddress = cusAddress;
        this.cusContactNo = cusContactNo;
        this.cusEmail = cusEmail;
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

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusContactNo() {
        return cusContactNo;
    }

    public void setCusContactNo(String cusContactNo) {
        this.cusContactNo = cusContactNo;
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
    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

//    @Override
//    public String toString() {
//        return String.format("%-20s %-6s %-18s %-10s %-25s %-20s %-10s",cusName,cusIc,cusGender,cusAddress,cusContactNo,cusEmail); //To change body of generated methods, choose Tools | Templates.
//    }

    
    
}
