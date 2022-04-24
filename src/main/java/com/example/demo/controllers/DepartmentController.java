package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // get all departments' information and return the view
    @GetMapping("/departments")
    public String allDepartments(Model model){
        model.addAttribute("departments", departmentService.getAllEntities());
        return "departments";
    }


} // class ends here
