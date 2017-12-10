package entity;

import java.io.Serializable;

public class HumanResource extends Staff implements Serializable {

    public HumanResource() {
    }

    public HumanResource(
            String fname,
            String lname,
            char gender,
            String nric,
            Contact contact,
            String username,
            String password) {

        super(fname, lname, gender, nric, contact, username, password);
    }

}
