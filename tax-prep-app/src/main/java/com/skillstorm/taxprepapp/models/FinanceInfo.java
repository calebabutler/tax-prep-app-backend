package com.skillstorm.taxprepapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

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

    @Column(name = "oauth_id")
    private String oauthId;

    public FinanceInfo() {
    }

    public FinanceInfo(Integer id, String filingStatus, String spouseFirstName, String spouseMiddleInitial,
                       String spouseLastName, Integer spouseSsn, Integer w2Income, Integer otherIncome,
                       Integer taxWithheldW2, Integer taxWithheld1099, Integer taxWithheldOther, Integer prevTaxesPaid,
                       String oauthId) {
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
        this.oauthId = oauthId;
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

        FinanceInfo that = (FinanceInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(filingStatus, that.filingStatus) &&
                Objects.equals(spouseFirstName, that.spouseFirstName) &&
                Objects.equals(spouseMiddleInitial, that.spouseMiddleInitial) &&
                Objects.equals(spouseLastName, that.spouseLastName) &&
                Objects.equals(spouseSsn, that.spouseSsn) && Objects.equals(w2Income, that.w2Income) &&
                Objects.equals(otherIncome, that.otherIncome) &&
                Objects.equals(taxWithheldW2, that.taxWithheldW2) &&
                Objects.equals(taxWithheld1099, that.taxWithheld1099) &&
                Objects.equals(taxWithheldOther, that.taxWithheldOther) &&
                Objects.equals(prevTaxesPaid, that.prevTaxesPaid) &&
                Objects.equals(oauthId, that.oauthId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(filingStatus);
        result = 31 * result + Objects.hashCode(spouseFirstName);
        result = 31 * result + Objects.hashCode(spouseMiddleInitial);
        result = 31 * result + Objects.hashCode(spouseLastName);
        result = 31 * result + Objects.hashCode(spouseSsn);
        result = 31 * result + Objects.hashCode(w2Income);
        result = 31 * result + Objects.hashCode(otherIncome);
        result = 31 * result + Objects.hashCode(taxWithheldW2);
        result = 31 * result + Objects.hashCode(taxWithheld1099);
        result = 31 * result + Objects.hashCode(taxWithheldOther);
        result = 31 * result + Objects.hashCode(prevTaxesPaid);
        result = 31 * result + Objects.hashCode(oauthId);
        return result;
    }

    @Override
    public String toString() {
        return "FinanceInfo{" +
                "id=" + id +
                ", filingStatus='" + filingStatus + '\'' +
                ", spouseFirstName='" + spouseFirstName + '\'' +
                ", spouseMiddleInitial='" + spouseMiddleInitial + '\'' +
                ", spouseLastName='" + spouseLastName + '\'' +
                ", spouseSsn=" + spouseSsn +
                ", w2Income=" + w2Income +
                ", otherIncome=" + otherIncome +
                ", taxWithheldW2=" + taxWithheldW2 +
                ", taxWithheld1099=" + taxWithheld1099 +
                ", taxWithheldOther=" + taxWithheldOther +
                ", prevTaxesPaid=" + prevTaxesPaid +
                ", oauthId='" + oauthId + '\'' +
                '}';
    }

}
