package com.example.demo.service;

import com.example.demo.models.Department;
import com.example.demo.repository.CRUDInterface;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class DepartmentService {

    private CRUDInterface<Department> departmentRepository;

    public DepartmentService(CRUDInterface<Department> departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // get list of all available departments from DepartmentRepository
    // return the list to the controller
    public List<Department> getAllEntities(){
        return  departmentRepository.getAllEntities();
    }


    // get the highest department number
    public int getHighestDepartmentNumber(){
        List<Department> departments = departmentRepository.getAllEntities();

        int highestDepartmentNumber = 0;

        for (Department individualDepartment:departments) {
            if (individualDepartment.getDepartmentNumber() > highestDepartmentNumber) {
                highestDepartmentNumber = individualDepartment.getDepartmentNumber();
            }
        }
        return highestDepartmentNumber;
    }

} // class ends here
