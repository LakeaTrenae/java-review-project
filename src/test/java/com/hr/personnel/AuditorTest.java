package com.hr.personnel;

import com.hr.corp.Auditor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuditorTest {

    @Test
    public void testComputeMonthlyProfit() {
        Auditor auditor = new Auditor();

        double monthlyIncome = 100000.0;
        double monthlyFixedCost = 20000.0;
        double monthlyTaxToPay = 15000.0;

        // Expected result: income - (fixed cost + tax) = 100000 - (20000 + 15000) = 65000
        double expectedProfit = 65000.0;

        double actualProfit = auditor.computeMonthlyProfit(monthlyIncome, monthlyFixedCost, monthlyTaxToPay);

        assertEquals(expectedProfit, actualProfit, 0.01);
    }
}