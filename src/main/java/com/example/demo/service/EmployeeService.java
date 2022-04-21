package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private CRUDInterface<Employee> employeeRepository = new EmployeeRepository();

    public Employee getEmployeeById(int id){
        return employeeRepository.getSingleEntityById(id);
    }

    // get all employee data from database and return to the controller
    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeRepository.getAllEntities();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
        return employeeRepository.getAllEntities();
    }



}
