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

    private static final BracketEntry[] headOfHouseholdBracketTable = {
            new BracketEntry(57810000, 37),
            new BracketEntry(23125000, 35),
            new BracketEntry(18210000, 32),
            new BracketEntry(9535000, 24),
            new BracketEntry(5985000, 22),
            new BracketEntry(1570000, 12),
            new BracketEntry(0, 10),
    };

    public static long calculateTaxes(Profile profile, FinanceInfo info) {
        long taxableIncome = info.getW2Income() + info.getOtherIncome();
        long prePaid = info.getTaxWithheldW2() + info.getTaxWithheld1099() + info.getTaxWithheldOther() +
                info.getPrevTaxesPaid();

        BracketEntry[] bracketTable;

        if ("single".equals(info.getFilingStatus())) {
            bracketTable = singleBracketTable;
        } else if ("jointly".equals(info.getFilingStatus())) {
            bracketTable = jointlyBracketTable;
        } else if ("separately".equals(info.getFilingStatus())) {
            bracketTable = separatelyBracketTable;
        } else {
            bracketTable = headOfHouseholdBracketTable;
        }

        long taxes = 0;
        for (BracketEntry entry : bracketTable) {
            if (taxableIncome > entry.minIncome) {
                /* Should this round down? I feel like it should not */
                taxes += (taxableIncome - entry.minIncome) * entry.percentRate / 100;
                taxableIncome = entry.minIncome;
            }
        }

        /* Subtract pre-paid taxes */
        taxes -= prePaid;

        return taxes;
    }

}
