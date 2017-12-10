package entity;

import java.io.Serializable;

/**
 *
 * @author cheefoei's
 */
public class Contact implements Serializable {

    private String address;
    private String city;
    private long postcode;
    private String state;
    private String email;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(String address, String city, long postcode, String state, String email, String phoneNumber) {
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.state = state;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPostcode() {
        return postcode;
    }

    public void setPostcode(long postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
