package com.hr.personnel;

import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        // Create an instance of Employee
        Employee emp = new Employee("Nova Skyh", LocalDate.of(2024, 3, 18));

        // Print employee details
        System.out.println(emp);

        // Modify employee details
        emp.setName("Miink Chanel");
        emp.setHireDate(LocalDate.of(2016, 3, 30));

        // Print updated employee details
        System.out.println(emp);
    }
}
