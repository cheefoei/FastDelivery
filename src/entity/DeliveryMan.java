package entity;

import java.io.Serializable;
import java.util.Date;

public class DeliveryMan extends Staff implements Serializable {

    private String status;
    private String punched_status;
    private Date clock_in;
    private Date clock_out;

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
            String status,
            Date clock_in,
            String punched_status,
            Date clock_out) {

        super(fname, lname, gender, nric, address, email, phoneNumber, username, password);
        this.status = status;
        this.punched_status = punched_status;
        this.clock_in =clock_in;
        this.clock_out =clock_out;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}
