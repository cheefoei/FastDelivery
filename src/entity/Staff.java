package entity;

public class Staff {

    public String fname;
    public String lname;
    public String nric;
    public String address;
    public String email;
    public String phoneNumber;
    public String username;
    public String password;

    public Staff() {
    }

    public Staff(
            String fname,
            String lname,
            String nric,
            String address,
            String email,
            String phoneNumber,
            String username,
            String password) {

        this.fname = fname;
        this.lname = lname;
        this.nric = nric;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }
}
