package com.hr.personnel;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double annualSalary;

    public SalariedEmployee(String name, double annualSalary, LocalDate hireDate) {
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public String getEmployeeInfo() {
        return String.format("Salaried Employee: %s, Hire Date: %s, Salary: %.2f",
                getName(), getHireDate(), annualSalary);
    }
}