package entity;

import java.io.Serializable;

public class DeliveryMan extends Staff implements Serializable {

    private boolean isLeave;
    private boolean isResigned;
    private boolean isDeliveryAvailable;
    private int deliveryNumber;
    private String workingStatus;

    public DeliveryMan() {
    }

    public DeliveryMan(
            String fname,
            String lname,
            char gender,
            String nric,
            Contact contact,
            String username,
            String password) {

        super(fname, lname, gender, nric, contact, username, password);
        this.workingStatus = "Available";
        this.isLeave = false;
        this.isResigned = false;
        this.isDeliveryAvailable = true;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
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
