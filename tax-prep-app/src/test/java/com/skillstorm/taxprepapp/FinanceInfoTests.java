package com.skillstorm.taxprepapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillstorm.taxprepapp.models.FinanceInfo;

@SpringBootTest
public class FinanceInfoTests {

    @Test
    public void testConstructorsAndGetters() {
        FinanceInfo financeInfoWithId = new FinanceInfo(10, "Single", "Jane", "M", "Doe", 123456789, 19800101, 50000, 10000, 5000,
                2000, 1000, 2000, "12345abcde");
        assertEquals(financeInfoWithId, financeInfoWithId);

        FinanceInfo financeInfo = new FinanceInfo("Single", "Jane", "M", "Doe", 123456789, 19800101, 50000, 10000, 5000,
                2000, 1000, 2000, "12345abcde");

        assertEquals("Single", financeInfo.getFilingStatus());
        assertEquals("Jane", financeInfo.getSpouseFirstName());
        assertEquals("M", financeInfo.getSpouseMiddleInitial());
        assertEquals("Doe", financeInfo.getSpouseLastName());
        assertEquals(Integer.valueOf(123456789), financeInfo.getSpouseSsn());
        assertEquals(Integer.valueOf(19800101), financeInfo.getSpouseDateOfBirth());
        assertEquals(Integer.valueOf(50000), financeInfo.getW2Income());
        assertEquals(Integer.valueOf(10000), financeInfo.getOtherIncome());
        assertEquals(Integer.valueOf(5000), financeInfo.getTaxWithheldW2());
        assertEquals(Integer.valueOf(2000), financeInfo.getTaxWithheld1099());
        assertEquals(Integer.valueOf(1000), financeInfo.getTaxWithheldOther());
        assertEquals(Integer.valueOf(2000), financeInfo.getPrevTaxesPaid());
        assertEquals("12345abcde", financeInfo.getOauthId());
    }

    @Test
    public void testSetters() {
        FinanceInfo financeInfo = new FinanceInfo();

        financeInfo.setFilingStatus("Married");
        financeInfo.setSpouseFirstName("John");
        financeInfo.setSpouseMiddleInitial("D");
        financeInfo.setSpouseLastName("Smith");
        financeInfo.setSpouseSsn(987654321);
        financeInfo.setSpouseDateOfBirth(19850101);
        financeInfo.setW2Income(60000);
        financeInfo.setOtherIncome(15000);
        financeInfo.setTaxWithheldW2(6000);
        financeInfo.setTaxWithheld1099(3000);
        financeInfo.setTaxWithheldOther(2000);
        financeInfo.setPrevTaxesPaid(3000);
        financeInfo.setOauthId("67890fghij");

        assertEquals("Married", financeInfo.getFilingStatus());
        assertEquals("John", financeInfo.getSpouseFirstName());
        assertEquals("D", financeInfo.getSpouseMiddleInitial());
        assertEquals("Smith", financeInfo.getSpouseLastName());
        assertEquals(Integer.valueOf(987654321), financeInfo.getSpouseSsn());
        assertEquals(Integer.valueOf(19850101), financeInfo.getSpouseDateOfBirth());
        assertEquals(Integer.valueOf(60000), financeInfo.getW2Income());
        assertEquals(Integer.valueOf(15000), financeInfo.getOtherIncome());
        assertEquals(Integer.valueOf(6000), financeInfo.getTaxWithheldW2());
        assertEquals(Integer.valueOf(3000), financeInfo.getTaxWithheld1099());
        assertEquals(Integer.valueOf(2000), financeInfo.getTaxWithheldOther());
        assertEquals(Integer.valueOf(3000), financeInfo.getPrevTaxesPaid());
        assertEquals("67890fghij", financeInfo.getOauthId());
    }

    @Test
    public void testEqualsAndHashCode() {
        FinanceInfo financeInfo1 = new FinanceInfo("Single", "Jane", "M", "Doe", 123456789, 19800101, 50000, 10000,
                5000, 2000, 1000, 2000, "12345abcde");
        FinanceInfo financeInfo2 = new FinanceInfo("Single", "Jane", "M", "Doe", 123456789, 19800101, 50000, 10000,
                5000, 2000, 1000, 2000, "12345abcde");
        FinanceInfo financeInfo3 = new FinanceInfo("Married", "John", "D", "Smith", 987654321, 19850101, 60000, 15000,
                6000, 3000, 2000, 3000, "67890fghij");

        assertEquals(financeInfo1, financeInfo2);
        assertNotEquals(financeInfo1, financeInfo3);
        assertEquals(financeInfo1.hashCode(), financeInfo2.hashCode());
        assertNotEquals(financeInfo1.hashCode(), financeInfo3.hashCode());
    }

    @Test
    public void testToString() {
        FinanceInfo financeInfo = new FinanceInfo("Single", "Jane", "M", "Doe", 123456789, 19800101, 50000, 10000,
                5000, 2000, 1000, 2000, "12345abcde");

        String expectedToString = "FinanceInfo [id=null, filingStatus=Single, spouseFirstName=Jane, spouseMiddleInitial=M, spouseLastName=Doe, spouseSsn=123456789, spouseDateOfBirth=19800101, w2Income=50000, otherIncome=10000, taxWithheldW2=5000, taxWithheld1099=2000, taxWithheldOther=1000, prevTaxesPaid=2000, oauthId=12345abcde]";
        assertEquals(expectedToString, financeInfo.toString());
    }
}