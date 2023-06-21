package com.abhinay.cruddemo.Service;

import com.abhinay.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findbyId(int Id);
    Employee save(Employee theEmployee);

    void deleteById(int Id);
}
