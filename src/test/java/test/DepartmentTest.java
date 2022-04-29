package test;

import com.example.demo.models.Department;
import com.example.demo.repository.CRUDInterface;
import com.example.demo.service.DepartmentService;
import org.junit.jupiter.api.Test;
import repository.DepartmentTestRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentTest {

    @Test
    public void highestDepartmentNumber() {
        //Arrange
        CRUDInterface<Department> departmentTestRepository = new DepartmentTestRepository();
        DepartmentService departmentService = new DepartmentService(departmentTestRepository);
        int realHighestDepartmentNumber = 40;

        //Assign
        int highestDepartmentNumber = departmentService.getHighestDepartmentNumber();

        //Assert
        assertEquals(realHighestDepartmentNumber, highestDepartmentNumber);
    }

}// class ends here
