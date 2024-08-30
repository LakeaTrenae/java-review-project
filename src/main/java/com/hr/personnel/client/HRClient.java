package com.hr.personnel.client;

import com.hr.personnel.Department;
import com.hr.personnel.Employee;
import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;

import java.time.LocalDate;

public class HRClient {
    public static void main(String[] args) {
        // Create Department object
        Department department = new Department("Software Engineer Department", "Dubai");

        // Create two SalariedEmployee objects with specified names and hire dates
        SalariedEmployee salariedEmployee1 = new SalariedEmployee("Nova Skyh", 60000, LocalDate.of(2024, 3, 18));
        SalariedEmployee salariedEmployee2 = new SalariedEmployee("Miink Chanel", 75000, LocalDate.of(2016, 3, 30));

        // Create one HourlyEmployee object with the name "Cinnamon"
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", 53, 160, LocalDate.of(2024, 8, 1));

        // Add employees to the Department
        department.addEmployee(salariedEmployee1);
        department.addEmployee(salariedEmployee2);
        department.addEmployee(hourlyEmployee);

        // Call letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked method and display the result
        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        System.out.println("Number of employees who worked: " + numberOfEmployeesWhoWorked);
    }
}
