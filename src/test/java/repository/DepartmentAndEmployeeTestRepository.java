package repository;

import com.example.demo.models.Department;
import com.example.demo.models.DepartmentAndEmployee;
import com.example.demo.models.Employee;
import com.example.demo.repository.CRUDInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentAndEmployeeTestRepository implements CRUDInterface<DepartmentAndEmployee> {
    @Override
    public boolean create(DepartmentAndEmployee entity) {
        return false;
    }

    @Override
    public DepartmentAndEmployee getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<DepartmentAndEmployee> getAllEntities() {
        return null;
    }

    @Override
    public List<DepartmentAndEmployee> getAllEntitiesById(int id) {
        List<DepartmentAndEmployee> departmentAndEmployees = new ArrayList<>();
        Department department1 = new Department(10,"ACCOUNTING","NEW YORK");
        Department department2 = new Department (20,"RESEARCH","DALLAS");
        Department department3 = new Department(30,"SALES","CHICAGO");
        Department department4 = new Department (40,"OPERATIONS","BOSTON");
        Department department5 = new Department (40,"SERVICE","BOSTON");

        Date date = new Date(10-10-2022);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Peter", "Accountant", 1, date, 5000, 5, 1));
        employees.add(new Employee(2, "Ben", "Accountant", 1, date, 6000, 5, 2));
        employees.add(new Employee(3, "Amalie", "Accountant", 1, date, 2000, 5, 5));
        employees.add(new Employee(1, "Peter", "Accountant", 1, date, 5000, 5, 1));
        employees.add(new Employee(4, "Ben", "Accountant", 1, date, 6000, 5, 3));
        employees.add(new Employee(5, "Amalie", "Accountant", 1, date, 2000, 5, 3));
        employees.add(new Employee(6, "Amalie", "Accountant", 1, date, 2000, 5, 4));
        employees.add(new Employee(7, "Amalie", "Accountant", 1, date, 2000, 5, 3));
        employees.add(new Employee(8, "Amalie", "Accountant", 1, date, 2000, 5, 3));

        return null;
    }

    @Override
    public boolean update(DepartmentAndEmployee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
