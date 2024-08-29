package com.hr.personnel;

public class Department {
    private String name;
    private String location;
    private Employee[] employees;
    private int currentIndex;

    // Constructor to initialize the Department
    public Department(String name, String location) {
        this.name = name;
        this.location = location;
        this.employees = new Employee[100]; // Initialize the array with size 100
        this.currentIndex = 0; // Set currentIndex to 0 initially
    }

    // Method to add an Employee to the department
    public void addEmployee(Employee employee) {
        if (currentIndex < employees.length) {
            employees[currentIndex++] = employee;
        } else {
            System.out.println("Cannot add more employees, the array is full.");
        }
    }

    // Method to let employees work and return the number of employees who worked
    public int letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked() {
        int count = 0;
        for (int i = 0; i < currentIndex; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.work().equals(employee.getName() + " worked")) {
                count++;
            }
        }
        return count;
    }

}