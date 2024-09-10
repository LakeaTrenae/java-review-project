package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {

    public static final double FEDERAL_MINIMUM_HOURLY_WAGE = 7.0;

    private double hourlyRate;
    private double hoursWorkedPerMonth;

    public double getHourlyRate() {
        return hourlyRate;
    }


    public double getHoursWorkedPerMonth() {
        return hoursWorkedPerMonth;
    }

    public HourlyEmployee(String name, LocalDate hireDate, double hourlyRate, double hoursWorkedPerMonth) {
        super(name, hireDate);

        if (hourlyRate < FEDERAL_MINIMUM_HOURLY_WAGE) {
            throw new IllegalArgumentException("Hourly rate cannot be less than the federal minimum wage of $" + FEDERAL_MINIMUM_HOURLY_WAGE);
        }


        this.hourlyRate = hourlyRate;
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }

    @Override
    public double computeMonthlyCompensation() {
        return hourlyRate * hoursWorkedPerMonth;
    }

    @Override
    public double computeMonthlyTaxToPay() {
        double monthlyCompensation = computeMonthlyCompensation();
        return monthlyCompensation * HOURLY_TAX_RATE;
    }

    @Override
    public String getEmployeeInfo() {
        return String.format("Name: %s\nHire Date: %s\nHourly Rate: $%.2f\nHours Worked Per Month: %.2f",
                getName(), getHireDate(), hourlyRate, hoursWorkedPerMonth);
    }
}
