package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorkedPerMonth;

    public HourlyEmployee(String name, LocalDate hireDate, double hourlyRate, double hoursWorkedPerMonth) {
        super(name, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }

    @Override
    public double computeMonthlyCompensation() {
        return hourlyRate * hoursWorkedPerMonth;
    }

    @Override
    public String getEmployeeInfo() {
        return String.format("Name: %s\nHire Date: %s\nHourly Rate: $%.2f\nHours Worked Per Month: %.2f",
                getName(), getHireDate(), hourlyRate, hoursWorkedPerMonth);
    }
}
