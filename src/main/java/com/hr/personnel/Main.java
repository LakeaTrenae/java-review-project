package com.hr.personnel;

import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        // Create an instance of Employee
        Employee emp = new Employee("Nova Skyh", LocalDate.of(2024, 3, 18)) {
            @Override
            public double computeMonthlyTaxToPay() {
                return 0;
            }

            @Override
            public String getEmployeeInfo() {
                return "";
            }

            @Override
            public double computeMonthlyCompensation() {
                return 0;
            }
        };

        System.out.println(emp);


        //Modifying the employee
        emp.setName("Miink Chanel");
        emp.setHireDate(LocalDate.of(2016, 3, 30));

        System.out.println(emp);
    }
}
