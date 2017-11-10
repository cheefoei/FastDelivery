package entity;

public class Staff {

    public String fname;
    public String lname;
    public String nric;
    public String address;
    public String email;
    public int phoneNumber;
    public String username;
    public String password;

    public Staff() {
    }

    public Staff(String fname, String lname, String nric, String address, String email, int phoneNumber) {

        this.fname = fname;
        this.lname = lname;
        this.nric = nric;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
