package com.skillstorm.taxprepapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalyticsTest {
    
    private Map<String, Integer> stateFrequencies;
    private Map<String, Integer> filingStatusFrequencies;
    private Map<String, Integer> incomeFrequencies;

    @BeforeEach
    public void setUp() {
        stateFrequencies = new HashMap<>();
        stateFrequencies.put("CA", 100);
        stateFrequencies.put("NY", 200);

        filingStatusFrequencies = new HashMap<>();
        filingStatusFrequencies.put("Single", 300);
        filingStatusFrequencies.put("Married", 400);

        incomeFrequencies = new HashMap<>();
        incomeFrequencies.put("Low", 500);
        incomeFrequencies.put("High", 600);
    }

    @Test
    public void testGettersAndSetters() {
        Analytics analytics = new Analytics();
        analytics.setStateFrequencies(stateFrequencies);
        analytics.setFilingStatusFrequencies(filingStatusFrequencies);
        analytics.setIncomeFrequencies(incomeFrequencies);

        assertEquals(stateFrequencies, analytics.getStateFrequencies());
        assertEquals(filingStatusFrequencies, analytics.getFilingStatusFrequencies());
        assertEquals(incomeFrequencies, analytics.getIncomeFrequencies());
    }

    @Test
    public void testEqualsAndHashCode() {
        Analytics analytics1 = new Analytics(stateFrequencies, filingStatusFrequencies, incomeFrequencies);
        Analytics analytics2 = new Analytics(stateFrequencies, filingStatusFrequencies, incomeFrequencies);
        Analytics analytics3 = new Analytics();

        assertTrue(analytics1.equals(analytics2));
        assertTrue(analytics2.equals(analytics1));
        assertTrue(analytics1.hashCode() == analytics2.hashCode());

        assertFalse(analytics1.equals(analytics3));
        assertFalse(analytics1.equals(null));
        assertFalse(analytics1.equals(new Object()));
    }

    @Test
    public void testToString() {
        Analytics analytics = new Analytics(stateFrequencies, filingStatusFrequencies, incomeFrequencies);
        String expectedToString = "Analytics [stateFrequencies={NY=200, CA=100}, filingStatusFrequencies={Single=300, Married=400}, incomeFrequencies={High=600, Low=500}]";
        assertEquals(expectedToString, analytics.toString());
    }

}
