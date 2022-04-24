package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EmployeeService {
    private CRUDInterface<Employee> employeeRepository = new EmployeeRepository();

    // get detail of an individual employee by id and return it
    public Employee getEmployeeById(int id){
        return employeeRepository.getSingleEntityById(id);
    }

    // get all employee data from database and return to the controller
    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEntities();
    }

    // delete an employee by id
    public boolean deleteById(int id) {
        return employeeRepository.deleteById(id);
    }

    // add an employee
    public boolean addEmployee(
            String employeeName,
            String job,
            int manager,
            String hireDate,
            int salary,
            int commission,
            int departmentNumber
    )
    {
        //chek if date is in the right format or not
        // if right, add the employee, or return false
        if (hireDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            Date date = Date.valueOf(hireDate);
            Employee employee = new Employee(employeeName, job, manager, date , salary, commission, departmentNumber);
            return employeeRepository.create(employee);
        } else {
            return false;
        }
    }

    // edit an employee
    public boolean editEmployee(
            int id,
            String employeeName,
            String job,
            int manager,
            String hireDate,
            int salary,
            int commission,
            int departmentNumber
    )
    {
        //chek if date is in the right format or not
        // if right, edit the employee, or return false
        if (hireDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            Date date = Date.valueOf(hireDate);
            Employee employee = new Employee(id, employeeName, job, manager, date , salary, commission, departmentNumber);
            return employeeRepository.update(employee);
        } else {
            return false;
        }
    }
}
