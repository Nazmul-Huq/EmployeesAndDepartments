package com.example.demo.service;

import com.example.demo.models.DepartmentAndEmployee;
import com.example.demo.models.Employee;
import com.example.demo.repository.CRUDInterface;
import org.springframework.stereotype.Service;

import java.util.*;

public class EmployeeAnalysisService {

    private final CRUDInterface<Employee> employeeCRUDInterface;

    public EmployeeAnalysisService(CRUDInterface<Employee> employeeCRUDInterface) {
        this.employeeCRUDInterface = employeeCRUDInterface;
    }


    public boolean isSalaryAboveAverage(Employee employee){
        List<Employee> employees = employeeCRUDInterface.getAllEntities();
        int numberOfEmployee = 0;
        int TotalSalary = 0;


        for (Employee individualEmployee:employees) {
            numberOfEmployee +=1;
            TotalSalary += individualEmployee.getSalary();
        }
        double averageSalary = (TotalSalary/numberOfEmployee);

        if (employee.getSalary() > averageSalary) {
            return true;
        }
        return false;
    }



}
