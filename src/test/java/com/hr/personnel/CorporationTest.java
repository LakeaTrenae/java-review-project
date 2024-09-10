package com.hr.personnel;

import com.hr.corp.Auditor;
import com.hr.corp.CompanyHealth;
import com.hr.corp.Corporation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CorporationTest {

    private Auditor auditor;

    @Before
    public void setUp() {
        auditor = new Auditor();
    }

    @Test
    public void testComputeMonthlyTaxToPay() {
        Corporation corporation = new Corporation("Baddies in Tech", 2000000.00, auditor);

        double monthlyTax = corporation.computeMonthlyTaxToPay();

        double expectedTax = 2000000.00 * 0.20; // 20% of monthly income
        assertEquals(expectedTax, monthlyTax, 0.01);
    }

    @Test
    public void testComputeMonthlyTaxToPayWithZeroIncome() {
        Corporation corporation = new Corporation("ZeroCorp", 0.00, auditor);

        double monthlyTax = corporation.computeMonthlyTaxToPay();

        double expectedTax = 0.00; // 20% of 0 is 0
        assertEquals(expectedTax, monthlyTax, 0.01);
    }

    @Test
    public void testComputeMonthlyTaxToPayWithNegativeIncome() {
        Corporation corporation = new Corporation("NegativeCorp", -100000.00, auditor);

        double monthlyTax = corporation.computeMonthlyTaxToPay();

        double expectedTax = -100000.00 * 0.20; // 20% of negative income
        assertEquals(expectedTax, monthlyTax, 0.01);
    }

    @Test
    public void testPerformMonthlyAuditHealthy() {
        Corporation corporation = new Corporation("Healthy Corp", 300000.00, auditor);

        CompanyHealth health = corporation.performMonthlyAudit();

        assertEquals(CompanyHealth.HEALTHY, health);
    }

    @Test
    public void testPerformMonthlyAuditOK() {
        Corporation corporation = new Corporation("OK Corp", 15000.00, auditor);

        CompanyHealth health = corporation.performMonthlyAudit();

        assertEquals(CompanyHealth.OK, health);
    }

    @Test
    public void testPerformMonthlyAuditSick() {
        Corporation corporation = new Corporation("Sick Corp", 5000.00, auditor);

        CompanyHealth health = corporation.performMonthlyAudit();

        assertEquals(CompanyHealth.SICK, health);
    }

    @Test
    public void testPerformMonthlyAuditNoAuditor() {
        Corporation corporation = new Corporation("No Auditor Corp", 50000.00);

        CompanyHealth health = corporation.performMonthlyAudit();

        assertEquals(CompanyHealth.SICK, health);
    }
}