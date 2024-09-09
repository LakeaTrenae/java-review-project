package com.hr.personnel;

import com.hr.corp.Corporation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CorporationTest {

    @Test
    public void testComputeMonthlyTaxToPay() {

        Corporation corporation = new Corporation("Baddies in Tech", 2000000.00);

        double monthlyTax = corporation.computeMonthlyTaxToPay();

        double expectedTax = 2000000.00 * 0.20; // 20% of monthly income
        assertEquals(expectedTax, monthlyTax, 0.01);
    }

    @Test
    public void testComputeMonthlyTaxToPayWithZeroIncome() {
        Corporation corporation = new Corporation("ZeroCorp", 0.00);

        double monthlyTax = corporation.computeMonthlyTaxToPay();

        double expectedTax = 0.00; // 20% of 0 is 0
        assertEquals(expectedTax, monthlyTax, 0.01);
    }

    @Test
    public void testComputeMonthlyTaxToPayWithNegativeIncome() {
        Corporation corporation = new Corporation("NegativeCorp", -100000.00);

        double monthlyTax = corporation.computeMonthlyTaxToPay();

        double expectedTax = -100000.00 * 0.20; // 20% of negative income
        assertEquals(expectedTax, monthlyTax, 0.01);
    }
}