package entity;

import java.io.Serializable;

public class DeliveryMan extends Staff implements Serializable {

    private String status;

    public DeliveryMan() {
    }

    public DeliveryMan(
            String fname,
            String lname,
            String nric,
            String address,
            String email,
            String phoneNumber,
            String username,
            String password) {

        super(fname, lname, nric, address, email, phoneNumber, username, password);
    }

    public DeliveryMan(
            String fname,
            String lname,
            String nric,
            String address,
            String email,
            String phoneNumber,
            String username,
            String password,
            String status) {
        
        super(fname, lname, nric, address, email, phoneNumber, username, password);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
