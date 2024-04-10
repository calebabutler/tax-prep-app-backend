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
@Table(name = "FINANCES")
public class FinanceInfo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "filing_status")
    private String filingStatus;

    @Column(name = "spouse_first_name")
    private String spouseFirstName;

    @Column(name = "spouse_middle_initial")
    private String spouseMiddleInitial;

    @Column(name = "spouse_last_name")
    private String spouseLastName;

    @Column(name = "spouse_ssn")
    private int spouseSsn;

    @Column(name = "w2_income")
    private int w2Income;

    @Column(name = "other_income")
    private int otherIncome;

    @Column(name = "tax_withheld_w2")
    private int taxWithheldW2;

    @Column(name = "tax_withheld_1099")
    private int taxWithheld1099;

    @Column(name = "tax_withheld_other")
    private int taxWithheldOther;

    @Column(name = "prev_taxes_paid")
    private int prevTaxesPaid;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(targetEntity = Dependent.class, mappedBy = "financeInfo")
    private Set<Dependent> dependents;

    public FinanceInfo() {
    }

    public FinanceInfo(String filingStatus, String spouseFirstName, String spouseMiddleInitial, String spouseLastName,
            int spouseSsn, int w2Income, int otherIncome, int taxWithheldW2, int taxWithheld1099, int taxWithheldOther,
            int prevTaxesPaid, Profile profile, Set<Dependent> dependents) {
        this.filingStatus = filingStatus;
        this.spouseFirstName = spouseFirstName;
        this.spouseMiddleInitial = spouseMiddleInitial;
        this.spouseLastName = spouseLastName;
        this.spouseSsn = spouseSsn;
        this.w2Income = w2Income;
        this.otherIncome = otherIncome;
        this.taxWithheldW2 = taxWithheldW2;
        this.taxWithheld1099 = taxWithheld1099;
        this.taxWithheldOther = taxWithheldOther;
        this.prevTaxesPaid = prevTaxesPaid;
        this.profile = profile;
        this.dependents = dependents;
    }

    public FinanceInfo(int id, String filingStatus, String spouseFirstName, String spouseMiddleInitial,
            String spouseLastName, int spouseSsn, int w2Income, int otherIncome, int taxWithheldW2, int taxWithheld1099,
            int taxWithheldOther, int prevTaxesPaid, Profile profile, Set<Dependent> dependents) {
        this.id = id;
        this.filingStatus = filingStatus;
        this.spouseFirstName = spouseFirstName;
        this.spouseMiddleInitial = spouseMiddleInitial;
        this.spouseLastName = spouseLastName;
        this.spouseSsn = spouseSsn;
        this.w2Income = w2Income;
        this.otherIncome = otherIncome;
        this.taxWithheldW2 = taxWithheldW2;
        this.taxWithheld1099 = taxWithheld1099;
        this.taxWithheldOther = taxWithheldOther;
        this.prevTaxesPaid = prevTaxesPaid;
        this.profile = profile;
        this.dependents = dependents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(String filingStatus) {
        this.filingStatus = filingStatus;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseMiddleInitial() {
        return spouseMiddleInitial;
    }

    public void setSpouseMiddleInitial(String spouseMiddleInitial) {
        this.spouseMiddleInitial = spouseMiddleInitial;
    }

    public String getSpouseLastName() {
        return spouseLastName;
    }

    public void setSpouseLastName(String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }

    public int getSpouseSsn() {
        return spouseSsn;
    }

    public void setSpouseSsn(int spouseSsn) {
        this.spouseSsn = spouseSsn;
    }

    public int getW2Income() {
        return w2Income;
    }

    public void setW2Income(int w2Income) {
        this.w2Income = w2Income;
    }

    public int getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(int otherIncome) {
        this.otherIncome = otherIncome;
    }

    public int getTaxWithheldW2() {
        return taxWithheldW2;
    }

    public void setTaxWithheldW2(int taxWithheldW2) {
        this.taxWithheldW2 = taxWithheldW2;
    }

    public int getTaxWithheld1099() {
        return taxWithheld1099;
    }

    public void setTaxWithheld1099(int taxWithheld1099) {
        this.taxWithheld1099 = taxWithheld1099;
    }

    public int getTaxWithheldOther() {
        return taxWithheldOther;
    }

    public void setTaxWithheldOther(int taxWithheldOther) {
        this.taxWithheldOther = taxWithheldOther;
    }

    public int getPrevTaxesPaid() {
        return prevTaxesPaid;
    }

    public void setPrevTaxesPaid(int prevTaxesPaid) {
        this.prevTaxesPaid = prevTaxesPaid;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(Set<Dependent> dependents) {
        this.dependents = dependents;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((filingStatus == null) ? 0 : filingStatus.hashCode());
        result = prime * result + ((spouseFirstName == null) ? 0 : spouseFirstName.hashCode());
        result = prime * result + ((spouseMiddleInitial == null) ? 0 : spouseMiddleInitial.hashCode());
        result = prime * result + ((spouseLastName == null) ? 0 : spouseLastName.hashCode());
        result = prime * result + spouseSsn;
        result = prime * result + w2Income;
        result = prime * result + otherIncome;
        result = prime * result + taxWithheldW2;
        result = prime * result + taxWithheld1099;
        result = prime * result + taxWithheldOther;
        result = prime * result + prevTaxesPaid;
        result = prime * result + ((profile == null) ? 0 : profile.hashCode());
        result = prime * result + ((dependents == null) ? 0 : dependents.hashCode());
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
        FinanceInfo other = (FinanceInfo) obj;
        if (id != other.id)
            return false;
        if (filingStatus == null) {
            if (other.filingStatus != null)
                return false;
        } else if (!filingStatus.equals(other.filingStatus))
            return false;
        if (spouseFirstName == null) {
            if (other.spouseFirstName != null)
                return false;
        } else if (!spouseFirstName.equals(other.spouseFirstName))
            return false;
        if (spouseMiddleInitial == null) {
            if (other.spouseMiddleInitial != null)
                return false;
        } else if (!spouseMiddleInitial.equals(other.spouseMiddleInitial))
            return false;
        if (spouseLastName == null) {
            if (other.spouseLastName != null)
                return false;
        } else if (!spouseLastName.equals(other.spouseLastName))
            return false;
        if (spouseSsn != other.spouseSsn)
            return false;
        if (w2Income != other.w2Income)
            return false;
        if (otherIncome != other.otherIncome)
            return false;
        if (taxWithheldW2 != other.taxWithheldW2)
            return false;
        if (taxWithheld1099 != other.taxWithheld1099)
            return false;
        if (taxWithheldOther != other.taxWithheldOther)
            return false;
        if (prevTaxesPaid != other.prevTaxesPaid)
            return false;
        if (profile == null) {
            if (other.profile != null)
                return false;
        } else if (!profile.equals(other.profile))
            return false;
        if (dependents == null) {
            if (other.dependents != null)
                return false;
        } else if (!dependents.equals(other.dependents))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FinanceInfo [id=" + id + ", filingStatus=" + filingStatus + ", spouseFirstName=" + spouseFirstName
                + ", spouseMiddleInitial=" + spouseMiddleInitial + ", spouseLastName=" + spouseLastName + ", spouseSsn="
                + spouseSsn + ", w2Income=" + w2Income + ", otherIncome=" + otherIncome + ", taxWithheldW2="
                + taxWithheldW2 + ", taxWithheld1099=" + taxWithheld1099 + ", taxWithheldOther=" + taxWithheldOther
                + ", prevTaxesPaid=" + prevTaxesPaid + ", profile=" + profile + "]";
    }


}
