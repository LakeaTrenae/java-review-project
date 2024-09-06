package com.hr.personnel;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double annualSalary;

    public SalariedEmployee(String name, LocalDate hireDate, double annualSalary) {
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double computeMonthlyCompensation() {
        return annualSalary / 12;
    }

    @Override
    public String getEmployeeInfo() {
        return String.format("Name: %s\nHire Date: %s\nMonthly Salary: $%.2f",
                getName(), getHireDate(), computeMonthlyCompensation());
    }
}