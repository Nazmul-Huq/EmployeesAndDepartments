package com.example.demo.controllers;

import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

    EmployeeService employeeService;
    DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    // get and return all employee data from the database
    @GetMapping("/see-all-employee")
    public String seeAllEmployee(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "see-all-employee";
    }

    // get and make view for an individual employee (by id)
    @PostMapping("/employee")
    public String employee(@RequestParam int id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee";
    }

    // get data and make view to edit an employee (by id)
    @PostMapping("/edit-employee")
    public String editEmployeePage(@RequestParam int id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit-employee";
    }

    // edit an employee data
    @PostMapping("edit-employee-handler")
    public String editEmployeeHandler(
            @RequestParam int id,
            @RequestParam String employeeName,
            @RequestParam String job,
            @RequestParam (value = "manager", required = false, defaultValue = "0") int manager,
            @RequestParam String hireDate,
            @RequestParam (value = "salary", required = false, defaultValue = "0") int salary,
            @RequestParam (value = "commission", required = false, defaultValue = "0") int commission,
            @RequestParam int departmentNumber,
            @ModelAttribute("userModel") final Object userModel,
            final RedirectAttributes redirectAttributes
    )
    {
        boolean isEmployeeEdited = employeeService.editEmployee(id, employeeName, job, manager, hireDate, salary, commission, departmentNumber);

        // if edition succeed then send succeed message
        // else send failed message
        if (isEmployeeEdited) {
            redirectAttributes.addFlashAttribute("userModel", "Employee was edited successfully");
            return "redirect:/succeed";
        } else {
            String message =message = "Employee was not edited. Something went wrong. Try again later";
            redirectAttributes.addFlashAttribute("userModel", message);
            return "redirect:/succeed";
        }
    }

    // get available departments name and  make the add employee view page
    @GetMapping("/add-employee")
    public String addEmployee(Model model){
        model.addAttribute("departments", departmentService.getAllEntities());
        return "add-employee";
    }

    // add an employee to the database
    @PostMapping("/add-employee-handler")
    public String addEmployeeHandler(
            @RequestParam String employeeName,
            @RequestParam String job,
            @RequestParam (value = "manager", required = false, defaultValue = "0") int manager,
            @RequestParam String hireDate,
            @RequestParam (value = "salary", required = false, defaultValue = "0") int salary,
            @RequestParam (value = "commission", required = false, defaultValue = "0") int commission,
            @RequestParam int departmentNumber,
            @ModelAttribute("userModel") final Object userModel,
            final RedirectAttributes redirectAttributes
            )
    {
        boolean isEmployeeAdded = employeeService.addEmployee(employeeName, job, manager, hireDate, salary, commission, departmentNumber);

        // if addition succeed then send succeed message
        // else send failed message
        if (isEmployeeAdded) {
            String message =message = "Employee was added successfully";
            redirectAttributes.addFlashAttribute("userModel", message);
            return "redirect:/succeed";
        } else {
            String message =message = "Employee was not added. Something went wrong. Try again later";
            redirectAttributes.addFlashAttribute("userModel", message);
            return "redirect:/succeed";
        }
    }


    // delete an employee by id
    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(
            @PathVariable int id,
            @ModelAttribute("userModel") final Object userModel,
            final RedirectAttributes redirectAttributes
         )
    {
        boolean isDeleteSuccess = employeeService.deleteById(id);
        String message = "";

        // if deletion succeed then send succeed message
        // else send failed message
        if(isDeleteSuccess){
            message = "Employee was deleted successfully";
            redirectAttributes.addFlashAttribute("userModel", message);
            return "redirect:/succeed";
        } else {
            message = "Employee was not deleted. Something went wrong. Try again later";
            redirectAttributes.addFlashAttribute("userModel", message);
            return "redirect:/succeed";
        }
    }

    // make view page after an employee is edited or deleted with succeed or failure message
    @GetMapping("/succeed")
    public String succeed(@ModelAttribute("userModel") final Object userModel,
                          final Model model){
        model.addAttribute("message", userModel.toString());
        return "succeed";
    }


} // class ends here
