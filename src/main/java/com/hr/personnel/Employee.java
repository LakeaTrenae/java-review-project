package com.hr.personnel;

import java.time.LocalDate;

public abstract class Employee {
    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String work() {
        return name + " worked"; // Example implementation
    }

    public abstract String getEmployeeInfo();

}




/*
private: Only within the same class.
Use: To hide data and methods from other classes.


default (package-private): Within the same package.
Use: To restrict access to classes in the same package.


protected: Within the same package and subclasses.
Use: To allow access in subclasses and the same package.


public: Accessible Everywhere.
Use: To make data or methods accessible from any class.


Why Make Fields private?

Encapsulation: Protects data and controls access.
Integrity: Ensures data is not changed unexpectedly.
Flexibility: Allows changes without affecting other classes.


@Before Annotation in JUnit 4
Purpose: Runs a method before each test to set up the test environment.
Use: To prepare common test data or objects, avoiding code duplication.
 */