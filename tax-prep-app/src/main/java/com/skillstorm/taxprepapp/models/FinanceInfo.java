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
@Table(name = "FINANCES")
public class FinanceInfo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filing_status")
    private String filingStatus;

    @Column(name = "spouse_first_name")
    private String spouseFirstName;

    @Column(name = "spouse_middle_initial")
    private String spouseMiddleInitial;

    @Column(name = "spouse_last_name")
    private String spouseLastName;

    @Column(name = "spouse_ssn")
    private Integer spouseSsn;

    @Column(name = "w2_income")
    private Integer w2Income;

    @Column(name = "other_income")
    private Integer otherIncome;

    @Column(name = "tax_withheld_w2")
    private Integer taxWithheldW2;

    @Column(name = "tax_withheld_1099")
    private Integer taxWithheld1099;

    @Column(name = "tax_withheld_other")
    private Integer taxWithheldOther;

    @Column(name = "prev_taxes_paid")
    private Integer prevTaxesPaid;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public FinanceInfo() {
    }

    public FinanceInfo(String filingStatus, String spouseFirstName, String spouseMiddleInitial, String spouseLastName,
            Integer spouseSsn, Integer w2Income, Integer otherIncome, Integer taxWithheldW2, Integer taxWithheld1099, Integer taxWithheldOther,
            Integer prevTaxesPaid, Profile profile) {
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
    }

    public FinanceInfo(Integer id, String filingStatus, String spouseFirstName, String spouseMiddleInitial,
            String spouseLastName, Integer spouseSsn, Integer w2Income, Integer otherIncome, Integer taxWithheldW2, Integer taxWithheld1099,
            Integer taxWithheldOther, Integer prevTaxesPaid, Profile profile) {
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
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSpouseSsn() {
        return spouseSsn;
    }

    public void setSpouseSsn(Integer spouseSsn) {
        this.spouseSsn = spouseSsn;
    }

    public Integer getW2Income() {
        return w2Income;
    }

    public void setW2Income(Integer w2Income) {
        this.w2Income = w2Income;
    }

    public Integer getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(Integer otherIncome) {
        this.otherIncome = otherIncome;
    }

    public Integer getTaxWithheldW2() {
        return taxWithheldW2;
    }

    public void setTaxWithheldW2(Integer taxWithheldW2) {
        this.taxWithheldW2 = taxWithheldW2;
    }

    public Integer getTaxWithheld1099() {
        return taxWithheld1099;
    }

    public void setTaxWithheld1099(Integer taxWithheld1099) {
        this.taxWithheld1099 = taxWithheld1099;
    }

    public Integer getTaxWithheldOther() {
        return taxWithheldOther;
    }

    public void setTaxWithheldOther(Integer taxWithheldOther) {
        this.taxWithheldOther = taxWithheldOther;
    }

    public Integer getPrevTaxesPaid() {
        return prevTaxesPaid;
    }

    public void setPrevTaxesPaid(Integer prevTaxesPaid) {
        this.prevTaxesPaid = prevTaxesPaid;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((filingStatus == null) ? 0 : filingStatus.hashCode());
        result = prime * result + ((spouseFirstName == null) ? 0 : spouseFirstName.hashCode());
        result = prime * result + ((spouseMiddleInitial == null) ? 0 : spouseMiddleInitial.hashCode());
        result = prime * result + ((spouseLastName == null) ? 0 : spouseLastName.hashCode());
        result = prime * result + ((spouseSsn == null) ? 0 : spouseSsn.hashCode());
        result = prime * result + ((w2Income == null) ? 0 : w2Income.hashCode());
        result = prime * result + ((otherIncome == null) ? 0 : otherIncome.hashCode());
        result = prime * result + ((taxWithheldW2 == null) ? 0 : taxWithheldW2.hashCode());
        result = prime * result + ((taxWithheld1099 == null) ? 0 : taxWithheld1099.hashCode());
        result = prime * result + ((taxWithheldOther == null) ? 0 : taxWithheldOther.hashCode());
        result = prime * result + ((prevTaxesPaid == null) ? 0 : prevTaxesPaid.hashCode());
        result = prime * result + ((profile == null) ? 0 : profile.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
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
        if (spouseSsn == null) {
            if (other.spouseSsn != null)
                return false;
        } else if (!spouseSsn.equals(other.spouseSsn))
            return false;
        if (w2Income == null) {
            if (other.w2Income != null)
                return false;
        } else if (!w2Income.equals(other.w2Income))
            return false;
        if (otherIncome == null) {
            if (other.otherIncome != null)
                return false;
        } else if (!otherIncome.equals(other.otherIncome))
            return false;
        if (taxWithheldW2 == null) {
            if (other.taxWithheldW2 != null)
                return false;
        } else if (!taxWithheldW2.equals(other.taxWithheldW2))
            return false;
        if (taxWithheld1099 == null) {
            if (other.taxWithheld1099 != null)
                return false;
        } else if (!taxWithheld1099.equals(other.taxWithheld1099))
            return false;
        if (taxWithheldOther == null) {
            if (other.taxWithheldOther != null)
                return false;
        } else if (!taxWithheldOther.equals(other.taxWithheldOther))
            return false;
        if (prevTaxesPaid == null) {
            if (other.prevTaxesPaid != null)
                return false;
        } else if (!prevTaxesPaid.equals(other.prevTaxesPaid))
            return false;
        if (profile == null) {
            if (other.profile != null)
                return false;
        } else if (!profile.equals(other.profile))
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
