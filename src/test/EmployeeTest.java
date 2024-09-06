import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void testSalariedEmployeeMonthlyCompensation() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Nova Skyh", LocalDate.of(2024, 3, 18), 60000);

        double monthlyCompensation = salariedEmployee.computeMonthlyCompensation();

        assertEquals(5000.0, monthlyCompensation, 0.01);
    }

    @Test
    public void testHourlyEmployeeMonthlyCompensation() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", LocalDate.of(2014, 4, 26), 20, 160);

        double monthlyCompensation = hourlyEmployee.computeMonthlyCompensation();

        assertEquals(3200.0, monthlyCompensation, 0.01);
    }

    @Test
    public void testSalariedEmployeeInfo() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Nova Skyh", LocalDate.of(2024, 3, 18), 60000);

        // Calculate monthly salary for salaried employee
        double monthlySalary = 60000.0 / 12; // $5000.00

        // Expected information for salaried employee
        String expectedInfo = String.format("Name: Nova Skyh\nHire Date: 2024-03-18\nMonthly Salary: $%.2f", monthlySalary);
        String actualInfo = salariedEmployee.getEmployeeInfo();

        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    public void testHourlyEmployeeInfo() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", LocalDate.of(2014, 4, 26), 20, 160);

        // Expected information for hourly employee
        String expectedInfo = "Name: Cinnamon\n" +
                "Hire Date: 2014-04-26\n" +
                "Hourly Rate: $20.00\n" +
                "Hours Worked Per Month: 160.00";
        String actualInfo = hourlyEmployee.getEmployeeInfo();

        assertEquals(expectedInfo, actualInfo);
    }
}