package com.skillstorm.taxprepapp.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser user;

    @OneToMany(targetEntity = FinanceInfo.class, mappedBy = "profile")
    private Set<FinanceInfo> financeInfo;

    public Profile() {
    }

    public Profile(String firstName, String middleInitial, String lastName, Integer dateOfBirth, String address,
            String city, String state, Integer aptNumber, Integer zipCode, Integer ssn, AppUser user, Set<FinanceInfo> financeInfo) {
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
        this.user = user;
        this.financeInfo = financeInfo;
    }

    public Profile(Integer id, String firstName, String middleInitial, String lastName, Integer dateOfBirth, String address,
            String city, String state, Integer aptNumber, Integer zipCode, Integer ssn, AppUser user, Set<FinanceInfo> financeInfo) {
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
        this.user = user;
        this.financeInfo = financeInfo;
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

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Set<FinanceInfo> getFinanceInfo() {
        return financeInfo;
    }

    public void setFinanceInfo(Set<FinanceInfo> financeInfo) {
        this.financeInfo = financeInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + dateOfBirth;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + aptNumber;
        result = prime * result + zipCode;
        result = prime * result + ssn;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((financeInfo == null) ? 0 : financeInfo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Profile other = (Profile) obj;
        if (id != other.id)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (middleInitial == null) {
            if (other.middleInitial != null)
                return false;
        } else if (!middleInitial.equals(other.middleInitial))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (dateOfBirth != other.dateOfBirth)
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (aptNumber != other.aptNumber)
            return false;
        if (zipCode != other.zipCode)
            return false;
        if (ssn != other.ssn)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (financeInfo == null) {
            if (other.financeInfo != null)
                return false;
        } else if (!financeInfo.equals(other.financeInfo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profile [id=" + id + ", firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName="
                + lastName + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", city=" + city + ", state="
                + state + ", aptNumber=" + aptNumber + ", zipCode=" + zipCode + ", ssn=" + ssn + ", user=" + user + "]";
    }

}
