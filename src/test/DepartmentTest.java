import com.hr.personnel.Department;
import com.hr.personnel.Employee;
import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;
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
        Employee employee = new SalariedEmployee("Alanii Milan", 50000, LocalDate.of(2022, 1, 1));
        department.addEmployee(employee);

        // Check if the employee was added correctly
        assertEquals(1, department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked());
    }

    @Test
    public void testLetEmployeesWorkAndReturnNumberOfEmployeesWhoWorked() {
        // Create employees
        Employee salariedEmployee1 = new SalariedEmployee("Nova Skyh", 60000, LocalDate.of(2024, 3, 18));
        Employee salariedEmployee2 = new SalariedEmployee("Miink Chanel", 75000, LocalDate.of(2016, 3, 30));
        Employee hourlyEmployee = new HourlyEmployee("Cinnamon", 20, 160, LocalDate.of(2014, 4, 26));

        // Add employees to the department
        department.addEmployee(salariedEmployee1);
        department.addEmployee(salariedEmployee2);
        department.addEmployee(hourlyEmployee);

        // Call the method and check the result
        int numberOfEmployeesWhoWorked = department.letEmployeesWorkAndReturnNumberOfEmployeesWhoWorked();
        assertEquals(3, numberOfEmployeesWhoWorked); // Assuming all employees' work() method returns the correct string
    }

}