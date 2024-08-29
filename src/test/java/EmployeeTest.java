package java;

import com.hr.personnel.Employee;
import org.junit.Test;

import java.time.LocalDate;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private Employee employee1;
    private Employee employee2;

    @Before
    public void setUp() {
        // Initialize Employee objects with updated names and hire dates
        employee1 = new Employee("Nova Skyh", LocalDate.of(2024, 3, 18)) {
            @Override
            public String getEmployeeInfo() {
                return "";
            }
        };
        employee2 = new Employee("Miink Chanel", LocalDate.of(2016, 3, 30)) {
            @Override
            public String getEmployeeInfo() {
                return "";
            }
        };
    }

    @Test
    public void testGetEmployeeInfo() {
        // Test getEmployeeInfo method for employee1
        String expectedInfo1 = "name = Nova Skyh, hireDate = 2024-03-18";
        assertEquals(expectedInfo1, employee1.getEmployeeInfo());

        // Test getEmployeeInfo method for employee2
        String expectedInfo2 = "name = Miink Chanel, hireDate = 2016-03-30";
        assertEquals(expectedInfo2, employee2.getEmployeeInfo());
    }

    @Test
    public void testWork() {
        // Test work method for employee1
        String expectedWork1 = "Nova Skyh worked";
        assertEquals(expectedWork1, employee1.work());

        // Test work method for employee2
        String expectedWork2 = "Miink Chanel worked";
        assertEquals(expectedWork2, employee2.work());
    }

    @Test
    public void testComputeNumberOfYearsWorkedSinceHired() {
        // Test computeNumberOfYearsWorkedSinceHired method
        int currentYear = LocalDate.now().getYear();
        int expectedYears1 = currentYear - 2024; // Assuming the current year is 2024
        assertEquals(expectedYears1, employee1.computeNumberOfYearsWorkedSinceHired());

        int expectedYears2 = currentYear - 2016; // Assuming the current year is 2024
        assertEquals(expectedYears2, employee2.computeNumberOfYearsWorkedSinceHired());
    }
}