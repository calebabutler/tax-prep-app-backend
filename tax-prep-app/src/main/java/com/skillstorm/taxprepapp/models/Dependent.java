package com.skillstorm.taxprepapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPENDENTS")
public class Dependent {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Integer ssn;

    @Column
    private String relationship;
    
    @ManyToOne
    @JoinColumn(name = "finances_id")
    private FinanceInfo financeInfo;

    public Dependent() {
    }

    public Dependent(String firstName, String lastName, Integer ssn, String relationship, FinanceInfo financeInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.relationship = relationship;
        this.financeInfo = financeInfo;
    }

    public Dependent(Integer id, String firstName, String lastName, Integer ssn, String relationship, FinanceInfo financeInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.relationship = relationship;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public FinanceInfo getFinanceInfo() {
        return financeInfo;
    }

    public void setFinanceInfo(FinanceInfo financeInfo) {
        this.financeInfo = financeInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ssn;
        result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());
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
        Dependent other = (Dependent) obj;
        if (id != other.id)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (ssn != other.ssn)
            return false;
        if (relationship == null) {
            if (other.relationship != null)
                return false;
        } else if (!relationship.equals(other.relationship))
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
        return "Dependent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn
                + ", relationship=" + relationship + ", financeInfo=" + financeInfo + "]";
    }

}
