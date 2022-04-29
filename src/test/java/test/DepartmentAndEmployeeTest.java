package test;

import com.example.demo.models.Employee;
import com.example.demo.repository.CRUDInterface;
import com.example.demo.service.DepartmentAndEmployeeService;
import com.example.demo.service.EmployeeAnalysisService;
import org.junit.jupiter.api.Test;
import repository.EmployeeTestRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentAndEmployeeTest {


    @Test
    public void departmentWithMostEmployee(){
        //ARRANGE
        final CRUDInterface<Employee> employeeTestRepository = new EmployeeTestRepository();
        DepartmentAndEmployeeService departmentAndEmployeeService = new DepartmentAndEmployeeService(employeeTestRepository);

        //ASSIGN
        String departmentWithMostEmployee = departmentAndEmployeeService.departmentWithMostEmployees();

        //ASSERT
        assertEquals("abc", departmentWithMostEmployee);

    }


}
