package entity;

import java.io.Serializable;

public class DeliveryMan extends Staff implements Serializable {

    private String status;

    public DeliveryMan() {
        this.status = "";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
