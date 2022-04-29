package test;

import com.example.demo.models.Employee;
import com.example.demo.repository.CRUDInterface;
import com.example.demo.service.EmployeeAnalysisService;
import repository.EmployeeTestRepository;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {


    @Test
    void isEmployeeSalaryAboveAverage() {

        //Arrange
        final CRUDInterface<Employee> employeeTestRepository = new EmployeeTestRepository();
        EmployeeAnalysisService employeeAnalysisService = new EmployeeAnalysisService(employeeTestRepository);
        Employee peter = new Employee(1, "Peter", "Accountant", 1, new Date(10-10-2022), 5000, 5, 1);


        //Assign
        boolean isEmployeeSalaryAboveAverage = employeeAnalysisService.isSalaryAboveAverage(peter);

        //Assert
        assertEquals(true, isEmployeeSalaryAboveAverage);
    }



}
