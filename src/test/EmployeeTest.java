import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void testSalariedEmployeeMonthlyCompensation() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Nova Skyh", 60000, LocalDate.of(2024, 3, 18));

        double monthlyCompensation = salariedEmployee.computeMonthlyCompensation();

        assertEquals(String.valueOf(5000.0), monthlyCompensation, "The monthly compensation should be 5000.0");
    }

    @Test
    public void testHourlyEmployeeMonthlyCompensation() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Cinnamon", 20, 160, LocalDate.of(2014, 4, 26));

        double monthlyCompensation = hourlyEmployee.computeMonthlyCompensation();

        assertEquals(String.valueOf(3200.0), monthlyCompensation, "The monthly compensation should be 3200.0");
    }
}