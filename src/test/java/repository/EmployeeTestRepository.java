package repository;

import com.example.demo.models.Employee;
import com.example.demo.repository.CRUDInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeTestRepository implements CRUDInterface<Employee> {


    @Override
    public boolean create(Employee entity) {
        return false;
    }

    @Override
    public Employee getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEntities() {
        Date date = new Date(10-10-2022);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Peter", "Accountant", 1, date, 5000, 5, 1));
        employees.add(new Employee(9, "Peter", "Accountant", 1, date, 5000, 5, 1));
        employees.add(new Employee(2, "Ben", "HR", 1, date, 6000, 5, 2));
        employees.add(new Employee(7, "Amalie", "Sales", 1, date, 2000, 5, 3));
        employees.add(new Employee(8, "Amalie", "Sales", 1, date, 2000, 5, 3));
        employees.add(new Employee(4, "Ben", "Sales", 1, date, 6000, 5, 3));
        employees.add(new Employee(5, "Amalie", "Sales", 1, date, 2000, 5, 3));
        employees.add(new Employee(6, "Amalie", "SEO", 1, date, 2000, 5, 4));
        employees.add(new Employee(3, "Amalie", "Marketing", 1, date, 2000, 5, 5));

        return employees;
    }

    @Override
    public List<Employee> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
