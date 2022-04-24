package com.example.demo.controllers;

import com.example.demo.models.DepartmentAndEmployee;
import com.example.demo.service.DepartmentAndEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DepartmentAndEmployeeController {

    DepartmentAndEmployeeService employeeAndDepartmentService;

    public DepartmentAndEmployeeController(DepartmentAndEmployeeService employeeAndDepartmentService) {
        this.employeeAndDepartmentService = employeeAndDepartmentService;
    }

    // get all employees' information by department and return view
    @PostMapping("/employee-by-department")
    public String employeeByDepartment(@RequestParam(name = "department-number") int departmentNumber, Model model){
        List<DepartmentAndEmployee> departmentAndEmployeeList = employeeAndDepartmentService.getEmployeeByDepartment(departmentNumber);
        model.addAttribute("employeesByDepartment", departmentAndEmployeeList);
        return "employee-by-department";
    }

}
