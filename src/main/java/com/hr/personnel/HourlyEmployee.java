package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(String name, double hourlyRate, int hoursWorked, LocalDate hireDate) {
        super(name, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getEmployeeInfo() {
        return String.format("Hourly Employee: %s, Hire Date: %s, Pay: %.2f",
                getName(), getHireDate(), hourlyRate * hoursWorked);
    }
}
