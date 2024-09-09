package com.hr.personnel;

import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DepartmentTest {

    private Department department;

    @Before
    public void setUp() {
        // Initialize the Department before each test
        department = new Department("Software Engineer Department", "Dubai");
    }

    @Test
    public void testAddEmployee() {
        // Create an employee and add to the department
        SalariedEmployee employee = new SalariedEmployee("Alanii Milan", LocalDate.of(2022, 1, 1), 50000);
        department.addEmployee(employee);

        // Check if the employee was added correctly
        // Note: `letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked()` might not be the correct method to verify addition.
        // A method to get the count of employees or check if the employee exists would be more appropriate.
        assertEquals(1, department.getCurrentIndex()); // Check current index to verify employee count
    }

    @Test
    public void testLetEmployeesWorkAndReturnNumberOfEmployeesWhoWorked() {

        SalariedEmployee salariedEmployee1 = new SalariedEmployee("Nova Skyh", LocalDate.of(2024, 3, 18), 60000);
        SalariedEmployee salariedEmployee2 = new SalariedEmployee("Miink Chanel", LocalDate.of(2016, 3, 30), 75000);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", LocalDate.of(2014, 4, 26), 20, 160);


        department.addEmployee(salariedEmployee1);
        department.addEmployee(salariedEmployee2);
        department.addEmployee(hourlyEmployee);

        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();

        assertEquals(3, numberOfEmployeesWhoWorked);
    }

    @Test
    public void testComputeDepartmentMonthlyTotalCompensation() {
        // Create employees with known monthly compensation
        SalariedEmployee salariedEmployee1 = new SalariedEmployee("Nova Skyh", LocalDate.of(2024, 3, 18), 60000);
        SalariedEmployee salariedEmployee2 = new SalariedEmployee("Miink Chanel", LocalDate.of(2016, 3, 30), 72000);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", LocalDate.of(2014, 4, 26), 25, 160);

        // Add employees to the department
        department.addEmployee(salariedEmployee1);
        department.addEmployee(salariedEmployee2);
        department.addEmployee(hourlyEmployee);

        // Calculate expected total compensation
        double expectedTotalCompensation = (25.0 * 160) + (60000.0 / 12) + (72000.0 / 12);
        double actualTotalCompensation = department.computeDepartmentMonthlyTotalCompensation();

        // Assert that the expected and actual total compensations match
        assertEquals(expectedTotalCompensation, actualTotalCompensation, 0.01);
    }
}