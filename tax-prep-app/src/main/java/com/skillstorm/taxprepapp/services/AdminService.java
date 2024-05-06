package com.skillstorm.taxprepapp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.skillstorm.taxprepapp.Analytics;
import com.skillstorm.taxprepapp.models.FinanceInfo;
import com.skillstorm.taxprepapp.models.Profile;
import com.skillstorm.taxprepapp.repositories.FinanceInfoRepository;
import com.skillstorm.taxprepapp.repositories.ProfileRepository;

@Service
public class AdminService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    FinanceInfoRepository financeInfoRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String test() {
        return "I am an admin!";
    }

    private Map<String, Integer> getStateFrequencies() {
        Map<String, Integer> stateFrequencies = new HashMap<>();
        for (Profile profile : profileRepository.findAll()) {
            Integer frequency = stateFrequencies.get(profile.getState());
            if (frequency == null) {
                frequency = 1;
            } else {
                frequency++;
            }
            stateFrequencies.put(profile.getState(), frequency);
        }
        return stateFrequencies;
    }

    private Map<String, Integer> getFilingStatusFrequencies() {
        Map<String, Integer> filingStatusFrequencies = new HashMap<>();
        for (FinanceInfo info : financeInfoRepository.findAll()) {
            Integer frequency = filingStatusFrequencies.get(info.getFilingStatus());
            if (frequency == null) {
                frequency = 1;
            } else {
                frequency++;
            }
            filingStatusFrequencies.put(info.getFilingStatus(), frequency);
        }
        return filingStatusFrequencies;
    }

    private Map<String, Integer> getIncomeFrequencies(int numberOfBins) {
        List<Integer> incomes = new ArrayList<>();

        for (FinanceInfo info : financeInfoRepository.findAll()) {
            incomes.add(info.getW2Income());
        }

        int binWidth = (Collections.max(incomes) - Collections.min(incomes)) / numberOfBins;
        Map<String, Integer> bins = new HashMap<>();

        for (int i = 0; i < numberOfBins; i++) {
            int binMinimum = binWidth * i + Collections.min(incomes);
            int binMaximum = binMinimum + binWidth;
            long frequency = incomes.stream().filter(income -> income >= binMinimum && income < binMaximum).count();
            bins.put(binMinimum + "-" + binMaximum, (int) frequency);
        }
        return bins;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Analytics calculateAnalytics() {
        return new Analytics(
            getStateFrequencies(),
            getFilingStatusFrequencies(),
            getIncomeFrequencies(5)
        );
    }

}
