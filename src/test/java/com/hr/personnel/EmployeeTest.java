package com.hr.personnel;

import com.gov.irs.TaxPayer;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void testSalariedEmployeeMonthlyCompensation() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Nova Skyh", LocalDate.of(2024, 3, 18), 60000);

        double monthlyCompensation = salariedEmployee.computeMonthlyCompensation();

        assertEquals(5000.0, monthlyCompensation, 0.01);
    }

    @Test
    public void testHourlyEmployeeMonthlyCompensation() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", LocalDate.of(2014, 4, 26), 20, 160);

        double monthlyCompensation = hourlyEmployee.computeMonthlyCompensation();

        assertEquals(3200.0, monthlyCompensation, 0.01);
    }

    @Test
    public void testSalariedEmployeeMonthlyTaxToPay() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Nova Skyh", LocalDate.of(2024, 3, 18), 60000);

        double monthlyTax = salariedEmployee.computeMonthlyTaxToPay();

        assertEquals(5000.0 * TaxPayer.SALARIED_TAX_RATE, monthlyTax, 0.01);
    }

    @Test
    public void testHourlyEmployeeMonthlyTaxToPay() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", LocalDate.of(2014, 4, 26), 20, 160);

        double monthlyTax = hourlyEmployee.computeMonthlyTaxToPay();

        assertEquals(3200.0 * TaxPayer.HOURLY_TAX_RATE, monthlyTax, 0.01);
    }

    public void testSalariedEmployeeInfo() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Nova Skyh", LocalDate.of(2024, 3, 18), 60000);

        // Calculate monthly salary for salaried employee
        double monthlySalary = 60000.0 / 12; // $5000.00

        // Expected information for salaried employee
        String expectedInfo = String.format("Name: %s\nHire Date: %s\nMonthly Salary: $%.2f",
                "Nova Skyh", LocalDate.of(2024, 3, 18), monthlySalary);
        String actualInfo = salariedEmployee.getEmployeeInfo();

        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    public void testHourlyEmployeeInfo() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", LocalDate.of(2014, 4, 26), 20, 160);

        // Expected information for hourly employee
        String expectedInfo = String.format("Name: %s\nHire Date: %s\nHourly Rate: $%.2f\nHours Worked Per Month: %.2f",
                "Cinnamon", LocalDate.of(2014, 4, 26), 20.0, 160.0);
        String actualInfo = hourlyEmployee.getEmployeeInfo();

        System.out.println("Expected Info: " + expectedInfo);
        System.out.println("Actual Info: " + actualInfo);


        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    public void testValidHourlyRate() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Valid Employee", LocalDate.of(2022, 1, 1), 10.0, 160);

        assertEquals("Valid Employee", hourlyEmployee.getName());
        assertEquals(LocalDate.of(2022, 1, 1), hourlyEmployee.getHireDate());
        assertEquals(10.0, hourlyEmployee.getHourlyRate(), 0.01);
        assertEquals(160, hourlyEmployee.getHoursWorkedPerMonth(), 0.01);
    }

    @Test
    public void testMinimumHourlyRate() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Min Wage Employee", LocalDate.of(2022, 1, 1), HourlyEmployee.FEDERAL_MINIMUM_HOURLY_WAGE, 160);

        assertEquals("Min Wage Employee", hourlyEmployee.getName());
        assertEquals(LocalDate.of(2022, 1, 1), hourlyEmployee.getHireDate());
        assertEquals(HourlyEmployee.FEDERAL_MINIMUM_HOURLY_WAGE, hourlyEmployee.getHourlyRate(), 0.01);
        assertEquals(160, hourlyEmployee.getHoursWorkedPerMonth(), 0.01);
    }

    @Test
    public void testInvalidHourlyRate() {
        try {
            new HourlyEmployee("Invalid Employee", LocalDate.of(2022, 1, 1), 6.0, 160);
            Assert.fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Hourly rate cannot be less than the federal minimum wage of $7.0", e.getMessage());
        }
    }


}