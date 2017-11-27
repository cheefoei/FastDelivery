package entity;

import java.io.Serializable;

public class DeliveryMan extends Staff implements Serializable {

    private boolean isLeave;
    private boolean isResigned;
    private boolean isDeliveryAvailable;
    private int deliveryNumber;

    public DeliveryMan() {
    }

    public DeliveryMan(
            String fname,
            String lname,
            char gender,
            String nric,
            String address,
            String email,
            String phoneNumber,
            String username,
            String password) {

        super(fname, lname, gender, nric, address, email, phoneNumber, username, password);
        this.isLeave = false;
        this.isResigned = false;
        this.isDeliveryAvailable = true;
    }

    public DeliveryMan(
            String fname,
            String lname,
            char gender,
            String nric,
            String address,
            String email,
            String phoneNumber,
            String username,
            String password,
            boolean isLeave,
            boolean isResigned,
            boolean isDeliveryAvailable) {

        super(fname, lname, gender, nric, address, email, phoneNumber, username, password);
        this.isLeave = isLeave;
        this.isResigned = isResigned;
        this.isDeliveryAvailable = isDeliveryAvailable;
    }

    public boolean isIsLeave() {
        return isLeave;
    }

    public void setIsLeave(boolean isLeave) {
        this.isLeave = isLeave;
    }

    public boolean isIsResigned() {
        return isResigned;
    }

    public void setIsResigned(boolean isResigned) {
        this.isResigned = isResigned;
    }

    public boolean isIsDeliveryAvailable() {
        return isDeliveryAvailable;
    }

    public void setIsDeliveryAvailable(boolean isDeliveryAvailable) {
        this.isDeliveryAvailable = isDeliveryAvailable;
    }

}
