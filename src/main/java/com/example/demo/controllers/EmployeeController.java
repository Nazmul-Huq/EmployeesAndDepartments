package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // get and return all employee from the database
    @GetMapping("/see-all-employee")
    public String seeAllEmployee(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "see-all-employee";
    }

    @PostMapping("/employee-by-id")
    public String seeEmployeeById(@RequestParam int employeeId, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
        return "employee";
    }

} // class ends here
