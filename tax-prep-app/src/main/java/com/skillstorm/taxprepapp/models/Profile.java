package com.skillstorm.taxprepapp.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PROFILES")
public class Profile {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="middle_initial")
  private String middleInitial;

  @Column(name="last_name")
  private String lastName;

  @Column(name="date_of_birth")
  private int dateOfBirth;

  @Column
  private String address;

  @Column
  private String city;

  @Column
  private String state;

  @Column(name="apt_number")
  private int aptNumber;

  @Column(name="zip_code")
  private int zipCode;

  @Column
  private int ssn;

  @OneToMany(targetEntity = FinanceInfo.class, mappedBy = "profile")
  private Set<FinanceInfo> financeInfo;
  
  public Profile() {
  }
  public Profile(int id, String firstName, String middleInitial, String lastName, int dateOfBirth, String address,
      String city, String state, int aptNumber, int zipCode, int ssn) {
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
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
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
  public int getDateOfBirth() {
    return dateOfBirth;
  }
  public void setDateOfBirth(int dateOfBirth) {
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
  public int getAptNumber() {
    return aptNumber;
  }
  public void setAptNumber(int aptNumber) {
    this.aptNumber = aptNumber;
  }
  public int getZipCode() {
    return zipCode;
  }
  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }
  public int getSsn() {
    return ssn;
  }
  public void setSsn(int ssn) {
    this.ssn = ssn;
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
    return true;
  }

  @Override
  public String toString() {
    return "Profile [id=" + id + ", firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName="
        + lastName + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", city=" + city + ", state=" + state
        + ", aptNumber=" + aptNumber + ", zipCode=" + zipCode + ", ssn=" + ssn + "]";
  }
  
}
