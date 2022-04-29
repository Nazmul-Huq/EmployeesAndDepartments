package repository;

import com.example.demo.models.Department;
import com.example.demo.repository.CRUDInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentTestRepository implements CRUDInterface<Department> {

List<Department> departments = new ArrayList<Department>(
        Arrays.asList(
                new Department(1,"ACCOUNTING","NEW YORK"),
                new Department (2,"RESEARCH","DALLAS"),
                new Department(3,"SALES","CHICAGO"),
                new Department (4,"OPERATIONS","BOSTON"),
                new Department (5,"MARKETING","BOSTON")

        ));


    @Override
    public boolean create(Department entity) {
        return false;
    }

    @Override
    public Department getSingleEntityById(int id) {


        return null;
    }

    @Override
    public List<Department> getAllEntities() {
        return departments;
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
