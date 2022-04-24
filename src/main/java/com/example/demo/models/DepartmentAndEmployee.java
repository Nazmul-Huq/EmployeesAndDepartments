package com.example.demo.models;

public class DepartmentAndEmployee {

    private Department department;
    private Employee employee;

    // default constructor
    public DepartmentAndEmployee() {
    }

    // constructor with all attribute
    public DepartmentAndEmployee(Department department, Employee employee) {
        this.department = department;
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
