package com.example.demo.repository;

import java.util.List;

public interface CRUDInterface <T>{
    //Create
    public boolean create(T entity);

    //Read
    public T getSingleEntityById(int id);
    public List<T> getAllEntities();
    public List<T> getAllEntitiesById(int id);

    //Update
    public boolean update(T entity);

    //Delete
    public boolean deleteById(int id);
}
