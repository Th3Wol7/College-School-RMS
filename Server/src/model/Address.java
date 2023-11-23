package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressID;
    @Column(name = "streetAddress")
    private String streetAddress;

    @Column(name = "state")
    private String state;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "country")
    private String country;

    // Default Constructor
    public Address() {
        setStreetAddress("N/A");
        setState("N/A");
        setZipCode("");
        setCountry("N/A");
    }

    //Primary Constructor
    public Address(String streetAddress, String state, String zipCode, String country) {
        setStreetAddress(streetAddress);
        setState(state);
        setZipCode(zipCode);
        setCountry(country);
    }

    public Address(Address obj) {
        setStreetAddress(obj.streetAddress);
        setState(obj.state);
        setZipCode(obj.zipCode);
        setCountry(obj.country);
    }

    //Getters and Setters


    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void displayAddress() {
        System.out.println("Street Address: " + getStreetAddress() + "\t State:" +
                getState() + "\t ZipCode: " + getZipCode() + "\t Country: " + getCountry());
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
