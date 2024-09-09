package com.hr.personnel;

import com.gov.irs.IRS;
import com.gov.irs.TaxPayer;
import com.hr.corp.Corporation;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

public class IRSTest{

    @Test
    public void testComputeTotalMonthlyTaxToCollect() {
        // Arrange
        IRS irs = new IRS();

        // Create TaxPayer instances with specific names and hire dates
        SalariedEmployee salariedEmployee = new SalariedEmployee("Nova Skyh", LocalDate.of(2024, 3, 18), 60000);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", LocalDate.of(2014, 4, 26), 20, 160);
        Corporation corporation = new Corporation("Baddies in Tech", 2000000.00);

        // Register TaxPayers
        irs.register(salariedEmployee);
        irs.register(hourlyEmployee);
        irs.register(corporation);

        // Act
        double totalTax = irs.computeTotalMonthlyTaxToCollect();

        // Calculate expected tax
        double expectedSalariedTax = salariedEmployee.computeMonthlyTaxToPay(); // Using 30% tax rate
        double expectedHourlyTax = hourlyEmployee.computeMonthlyTaxToPay(); // Using 25% tax rate
        double expectedCorporationTax = corporation.computeMonthlyTaxToPay(); // Assuming 20% tax rate for Corporation
        double expectedTotalTax = expectedSalariedTax + expectedHourlyTax + expectedCorporationTax;

        // Assert
        assertEquals(expectedTotalTax, totalTax, 0.01);
    }
}