package com.example.demo.models;

public class Department {
    private int departmentNumber;
    private String departmentName;
    private String location;

    // default constructor
    public Department() {
    }

    // constructor with all attributes
    public Department(int deptno, String deptName, String location) {
        this.departmentNumber = deptno;
        this.departmentName = deptName;
        this.location = location;
    }

    public int getDepartmentNumber() {
        return this.departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptno=" + departmentNumber +
                ", deptName='" + departmentName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
