package com.example.demo.controllers;

import com.example.demo.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
