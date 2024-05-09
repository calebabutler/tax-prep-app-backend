package com.skillstorm.taxprepapp;

import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.models.Profile;

public class TaxCalculator {

    private static class BracketEntry {
        long minIncome;
        long percentRate;

        public BracketEntry(long minIncome, long percentRate) {
            this.minIncome = minIncome;
            this.percentRate = percentRate;
        }
    }

    private static final BracketEntry[] singleBracketTable = {
            new BracketEntry(57812500, 37),
            new BracketEntry(23125000, 35),
            new BracketEntry(18210000, 32),
            new BracketEntry(9537500, 24),
            new BracketEntry(4472500, 22),
            new BracketEntry(1100000, 12),
            new BracketEntry(0, 10),
    };

    private static final BracketEntry[] jointlyBracketTable = {
            new BracketEntry(69375000, 37),
            new BracketEntry(46250000, 35),
            new BracketEntry(36420000, 32),
            new BracketEntry(19075000, 24),
            new BracketEntry(8945000, 22),
            new BracketEntry(2200000, 12),
            new BracketEntry(0, 10),
    };

    private static final BracketEntry[] separatelyBracketTable = {
            new BracketEntry(34687500, 37),
            new BracketEntry(23125000, 35),
            new BracketEntry(18210000, 32),
            new BracketEntry(9537500, 24),
            new BracketEntry(4472500, 22),
            new BracketEntry(1100000, 12),
            new BracketEntry(0, 10),
    };

    public static long calculateTaxes(Profile profile, FinanceInfo info) {
        long totalIncome = info.getW2Income() + info.getOtherIncome();
        long prePaid = info.getTaxWithheldW2() + info.getTaxWithheld1099() + info.getTaxWithheldOther() +
                info.getPrevTaxesPaid();

        BracketEntry[] bracketTable;
        long stdDeduction;

        if ("Single".equals(info.getFilingStatus())) {
            bracketTable = singleBracketTable;
            stdDeduction = 1385000;
        } else if ("Married Filing Jointly".equals(info.getFilingStatus())) {
            bracketTable = jointlyBracketTable;
            stdDeduction= 2770000;
        } else if ("Married Filing Separately".equals(info.getFilingStatus())) {
            bracketTable = separatelyBracketTable;
            stdDeduction= 2770000;
        } else {
            bracketTable = singleBracketTable;
            stdDeduction = 1385000;
        }
        
        long taxes = 0;
        if(stdDeduction >= totalIncome){
            return taxes -=prePaid;
        }else{
            long taxableIncome = totalIncome- stdDeduction;
            for (BracketEntry entry : bracketTable) {
                if (taxableIncome > entry.minIncome) {
                    taxes += (taxableIncome - entry.minIncome) * entry.percentRate / 100;
                    taxableIncome = entry.minIncome;
                }
            }
            /* Subtract pre-paid taxes */
            taxes -= prePaid;
            
            return taxes;
        }
    }
}
