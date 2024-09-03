package com.hr.personnel.client;

import com.hr.personnel.Department;
import com.hr.personnel.Employee;
import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;

import java.time.LocalDate;

public class HRClient {
    public static void main(String[] args) {
        Department department = new Department("Software Engineer Department", "Dubai");

        SalariedEmployee salariedEmployee1 = new SalariedEmployee("Nova Skyh", 60000, LocalDate.of(2024, 3, 18));
        SalariedEmployee salariedEmployee2 = new SalariedEmployee("Miink Chanel", 75000, LocalDate.of(2016, 3, 30));

        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", 53, 160, LocalDate.of(2024, 8, 1));

        department.addEmployee(salariedEmployee1);
        department.addEmployee(salariedEmployee2);
        department.addEmployee(hourlyEmployee);

        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        System.out.println("Number of employees who worked: " + numberOfEmployeesWhoWorked);

        double totalCompensation = department.computeDepartmentMonthlyTotalCompensation();
        System.out.println("Total monthly compensation of the department: " + totalCompensation);
    }
}
