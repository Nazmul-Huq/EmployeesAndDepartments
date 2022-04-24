package com.example.demo.service;

import com.example.demo.models.Department;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private CRUDInterface<Department> departmentRepository = new DepartmentRepository();

    // get list of all available departments from DepartmentRepository
    // return the list to the controller
    public List<Department> getAllEntities(){
        return  departmentRepository.getAllEntities();
    }
}
