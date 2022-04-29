package com.example.demo.repository;

import com.example.demo.models.Department;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  DepartmentRepository implements CRUDInterface<Department>{
    @Override
    public boolean create(Department entity) {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departments");

            return true;
        }
        catch (SQLException e){
            return false;
        }
    }

    @Override
    public Department getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Department> getAllEntities() {
        List<Department> departments = new ArrayList<>();
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departments");
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                Department department =  new Department(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                departments.add(department);
            }
            return departments;
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database");
            return null;
        }
    }

    @Override
    public List<Department> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
