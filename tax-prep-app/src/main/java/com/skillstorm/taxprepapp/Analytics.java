package com.skillstorm.taxprepapp;

import java.util.Map;

public class Analytics {

    private Map<String, Integer> stateFrequencies;
    private Map<String, Integer> filingStatusFrequencies;
    private Map<String, Integer> incomeFrequencies;

    public Analytics() {
    }

    public Analytics(Map<String, Integer> stateFrequencies, Map<String, Integer> filingStatusFrequencies,
            Map<String, Integer> incomeFrequencies) {
        this.stateFrequencies = stateFrequencies;
        this.filingStatusFrequencies = filingStatusFrequencies;
        this.incomeFrequencies = incomeFrequencies;
    }

    public Map<String, Integer> getStateFrequencies() {
        return stateFrequencies;
    }

    public void setStateFrequencies(Map<String, Integer> stateFrequencies) {
        this.stateFrequencies = stateFrequencies;
    }

    public Map<String, Integer> getFilingStatusFrequencies() {
        return filingStatusFrequencies;
    }

    public void setFilingStatusFrequencies(Map<String, Integer> filingStatusFrequencies) {
        this.filingStatusFrequencies = filingStatusFrequencies;
    }

    public Map<String, Integer> getIncomeFrequencies() {
        return incomeFrequencies;
    }

    public void setIncomeFrequencies(Map<String, Integer> incomeFrequencies) {
        this.incomeFrequencies = incomeFrequencies;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((stateFrequencies == null) ? 0 : stateFrequencies.hashCode());
        result = prime * result + ((filingStatusFrequencies == null) ? 0 : filingStatusFrequencies.hashCode());
        result = prime * result + ((incomeFrequencies == null) ? 0 : incomeFrequencies.hashCode());
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
        Analytics other = (Analytics) obj;
        if (stateFrequencies == null) {
            if (other.stateFrequencies != null)
                return false;
        } else if (!stateFrequencies.equals(other.stateFrequencies))
            return false;
        if (filingStatusFrequencies == null) {
            if (other.filingStatusFrequencies != null)
                return false;
        } else if (!filingStatusFrequencies.equals(other.filingStatusFrequencies))
            return false;
        if (incomeFrequencies == null) {
            if (other.incomeFrequencies != null)
                return false;
        } else if (!incomeFrequencies.equals(other.incomeFrequencies))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Analytics [stateFrequencies=" + stateFrequencies + ", filingStatusFrequencies="
                + filingStatusFrequencies + ", incomeFrequencies=" + incomeFrequencies + "]";
    }

}
