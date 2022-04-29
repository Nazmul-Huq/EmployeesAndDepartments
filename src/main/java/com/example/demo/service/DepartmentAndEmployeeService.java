package com.example.demo.service;

import com.example.demo.models.DepartmentAndEmployee;
import com.example.demo.models.Employee;
import com.example.demo.repository.CRUDInterface;
import com.example.demo.repository.DepartmentAndEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DepartmentAndEmployeeService {

    CRUDInterface departmentAndEmployeeRepository;

    public DepartmentAndEmployeeService(CRUDInterface departmentAndEmployeeRepository) {
        this.departmentAndEmployeeRepository = departmentAndEmployeeRepository;
    }

    // get and return all employee data of a particular department
    public List<DepartmentAndEmployee> getEmployeeByDepartment(int departmentNumber) {
        return departmentAndEmployeeRepository.getAllEntitiesById(departmentNumber);
    }


    public String departmentWithMostEmployees(){

        List<Employee> employees = departmentAndEmployeeRepository.getAllEntities();

        HashMap<Integer, Integer> employeeByDepartment = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            int departmentNumber = employees.get(i).getDepartmentNumber();
            if (employeeByDepartment.containsKey(departmentNumber)) {
                int value = employeeByDepartment.get(departmentNumber);
                value +=1;
                employeeByDepartment.put(departmentNumber, value);
            } else {
                employeeByDepartment.put(departmentNumber, 1);
            }
        }

        int highestEmployee = 0;
        int departmentNumberWithHighestEmployee = 0;
        Iterator<Integer> it = employeeByDepartment.keySet().iterator();
        while(it.hasNext())
        {
            int key=(int)it.next();
            if (employeeByDepartment.get(key) > highestEmployee) {
                highestEmployee = employeeByDepartment.get(key);
                departmentNumberWithHighestEmployee = key;
            }
        }


        System.out.println(departmentNumberWithHighestEmployee);



        return "abc";
    }


} // class ends here
