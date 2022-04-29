package com.example.demo.repository;

import com.example.demo.models.Department;
import com.example.demo.models.DepartmentAndEmployee;
import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentAndEmployeeRepository implements CRUDInterface<DepartmentAndEmployee> {

    public List<DepartmentAndEmployee> getAllEntitiesById(int id) {
        List<DepartmentAndEmployee> departmentAndEmployees = new ArrayList<>();
        try {
            Connection connection = DatabaseConnectionManager.getConnection();
            //select * from employees join departments
            //on
            //employees.department_number = departments.department_number
            //where departments.department_number = 10
            String query = "select * from employees join departments on employees.department_number = departments.department_number where departments.department_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            Employee employee = new Employee(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getDate(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8)
                );

            Department department = new Department(
                    resultSet.getInt(9),
                    resultSet.getString(10),
                    resultSet.getString(11)
            );

                departmentAndEmployees.add(new DepartmentAndEmployee(department, employee));
            }

        }
        catch (SQLException e){
            return departmentAndEmployees;
        }
        return departmentAndEmployees;
    }

    @Override
    public boolean create(DepartmentAndEmployee entity) {
        return false;
    }

    @Override
    public DepartmentAndEmployee getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<DepartmentAndEmployee> getAllEntities() {
        return null;
    }

    @Override
    public boolean update(DepartmentAndEmployee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
