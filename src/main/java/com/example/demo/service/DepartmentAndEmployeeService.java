package com.example.demo.service;

import com.example.demo.models.DepartmentAndEmployee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.DepartmentAndEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentAndEmployeeService {

    CRUDInterface departmentAndEmployeeRepository = new DepartmentAndEmployeeRepository();

    // get and return all employee data of a particular department
    public List<DepartmentAndEmployee> getEmployeeByDepartment(int departmentNumber) {
        return departmentAndEmployeeRepository.getAllEntitiesById(departmentNumber);
    }
}
