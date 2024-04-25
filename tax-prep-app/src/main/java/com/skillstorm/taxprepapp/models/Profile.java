package com.skillstorm.taxprepapp.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROFILES")
public class Profile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_initial")
    private String middleInitial;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Integer dateOfBirth;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String state;

    @Column(name = "apt_number")
    private Integer aptNumber;

    @Column(name = "zip_code")
    private Integer zipCode;

    @Column
    private Integer ssn;

    @Column(name = "oauth_id")
    private String oauthId;

    public Profile() {
    }

    public Profile(Integer id, String firstName, String middleInitial, String lastName, Integer dateOfBirth,
                   String address, String city, String state, Integer aptNumber, Integer zipCode, Integer ssn,
                   String oauthId) {
        this.id = id;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.aptNumber = aptNumber;
        this.zipCode = zipCode;
        this.ssn = ssn;
        this.oauthId = oauthId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(Integer aptNumber) {
        this.aptNumber = aptNumber;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) && Objects.equals(firstName, profile.firstName) &&
                Objects.equals(middleInitial, profile.middleInitial) &&
                Objects.equals(lastName, profile.lastName) &&
                Objects.equals(dateOfBirth, profile.dateOfBirth) &&
                Objects.equals(address, profile.address) && Objects.equals(city, profile.city) &&
                Objects.equals(state, profile.state) && Objects.equals(aptNumber, profile.aptNumber) &&
                Objects.equals(zipCode, profile.zipCode) && Objects.equals(ssn, profile.ssn) &&
                Objects.equals(oauthId, profile.oauthId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(middleInitial);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(dateOfBirth);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(aptNumber);
        result = 31 * result + Objects.hashCode(zipCode);
        result = 31 * result + Objects.hashCode(ssn);
        result = 31 * result + Objects.hashCode(oauthId);
        return result;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", aptNumber=" + aptNumber +
                ", zipCode=" + zipCode +
                ", ssn=" + ssn +
                ", oauthId='" + oauthId + '\'' +
                '}';
    }

}
