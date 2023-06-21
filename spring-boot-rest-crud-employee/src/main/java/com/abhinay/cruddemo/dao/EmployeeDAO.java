package com.abhinay.cruddemo.dao;

import com.abhinay.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findbyId(int Id);
    Employee save(Employee theEmployee);

    void deleteById(int Id);
}
