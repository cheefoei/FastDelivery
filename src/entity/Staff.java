package entity;

public class Staff {

    public String fname;
    public String lname;
    public char gender;
    public String nric;
    public Contact contact;
    public String username;
    public String password;

    public Staff() {
    }

    public Staff(
            String fname,
            String lname,
            char gender,
            String nric,
            Contact contact,
            String username,
            String password) {

        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.nric = nric;
        this.contact = contact;
        this.username = username;
        this.password = password;
    }
}
