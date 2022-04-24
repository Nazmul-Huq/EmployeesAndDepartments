package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements CRUDInterface<Employee>{

    // add an employee to the database
    @Override
    public boolean create(Employee entity) {
        //INSERT INTO `employees_departments`.`employees` (`id`, `employee_name`, `job`, `manager`, `hiredate`, `salary`, `commission`, `department_number`) VALUES ('7000', 'Delete', 'delete', '7782', '1982-01-23', '1200', '5', '10');

       try {
           Connection connection = DatabaseConnectionManager.getConnection();
           String query = "INSERT INTO employees (`employee_name`, `job`, `manager`, `hiredate`, `salary`, `commission`, `department_number`) VALUES (?, ?, ?, ?, ?, ?, ?)";
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1, entity.getEmployeeName());
           preparedStatement.setString(2, entity.getJob());
           preparedStatement.setInt(3, entity.getManager());
           preparedStatement.setDate(4, (Date) entity.getHireDate());
           preparedStatement.setInt(5, entity.getSalary());
           preparedStatement.setInt(6, entity.getCommission());
           preparedStatement.setInt(7, entity.getDepartmentNumber());
           int row = preparedStatement.executeUpdate();
           if (row == 0) {
               return false;
           } else {
               return true;
           }
       }
       catch (SQLException e){
           return false;
       }
    }

    // get data of an individual employee by id from database
    @Override
    public Employee getSingleEntityById(int id) {

        try {
            Connection connection = DatabaseConnectionManager.getConnection();
            String query = "SELECT * FROM employees WHERE  id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDate(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8)
                );
            }

        }
        catch (SQLException e){
            return new Employee();
        }
        return new Employee();
    }

    /**
     * get all employee from database and return to the service
     * @return
     */
    @Override
    public List<Employee> getAllEntities() {
        List<Employee> employees = new ArrayList<>();

        try{
            Connection connection = DatabaseConnectionManager.getConnection();
            String query = "SELECT * FROM employees";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
                employees.add(employee);
            }
            return employees;
        }
        catch (SQLException e){
            return employees;
        }
    }

    @Override
    public List<Employee> getAllEntitiesById(int id) {
        return null;
    }

    // update an employee data
    @Override
    public boolean update(Employee entity) {
        //UPDATE employees SET `employee_name` = 'test2', `job` = 'test2', `manager` = '50', `hiredate` = '2022-02-30', `salary` = '2200', `commission` = '2200' WHERE (`id` = '7938');
        Date date = (Date) entity.getHireDate();
        try {
            Connection connection = DatabaseConnectionManager.getConnection();
            String query = "UPDATE employees SET  employee_name = ?, `job` = ?, `manager` = ?,  `hiredate` = ?, `salary` = ?, `commission` = ?, `department_number` = ? WHERE (`id` = ?)";
            String query3 = "UPDATE employees SET  employee_name = ?, `job` = ?, `manager` = ?,  `hiredate` = ?, `salary` = ?, `commission` = ?, `departmentNumber` = ?, WHERE (`id` = ?)";
            String query2 = "UPDATE users SET email = ?, address= ?, phone= ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getEmployeeName());
            preparedStatement.setString(2, entity.getJob());
            preparedStatement.setInt(3, entity.getManager());
            preparedStatement.setDate(4, date);
            preparedStatement.setInt(5, entity.getSalary());
            preparedStatement.setInt(6, entity.getCommission());
            preparedStatement.setInt(7, entity.getDepartmentNumber());
            preparedStatement.setInt(8, entity.getId());
            int row = preparedStatement.executeUpdate();
            if (row == 0){
                return false;
            } else {
                return true;
            }
        }
        catch (SQLException e){
            return false;
        }
    }

    /**
     * delete an employee by id
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(int id) {
        try {
            Connection connection = DatabaseConnectionManager.getConnection();
            String query = "DELETE FROM employees WHERE  id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            if (row == 0){
                return false;
            } else {
                return true;
            }
        }
        catch (SQLException e){
            return false;
        }
    }

} // class ends here
