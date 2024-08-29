package com.hr.personnel.client;

import com.hr.personnel.Employee;

import java.time.LocalDate;

class HRClient {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Nova Skyh", LocalDate.of(2024, 3, 18));
        Employee employee2 = new Employee("Miink Chanel", LocalDate.of(2016, 3, 30));

        // Call getEmployeeInfo method and display the result
        System.out.println(employee1.getEmployeeInfo());
        System.out.println(employee2.getEmployeeInfo());
    }
}
