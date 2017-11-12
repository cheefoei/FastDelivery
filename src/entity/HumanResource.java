package entity;

import java.io.Serializable;

public class HumanResource extends Staff implements Serializable {

    public HumanResource() {
    }

    public HumanResource(
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

}
