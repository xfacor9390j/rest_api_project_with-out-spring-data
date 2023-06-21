package com.abhinay.cruddemo.dao;

import com.abhinay.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //define field for entity manager
    private EntityManager entityManager;


    //setup constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee>thequery=entityManager.createQuery("from Employee",Employee.class);

        //execute query and get result list
        List<Employee>employees=thequery.getResultList();

        //return list
        return employees;
    }

    @Override
    public Employee findbyId(int Id) {
        //get employee
        Employee theEmployee=entityManager.find(Employee.class,Id);

        //return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save the employee
        Employee dbEmployee=entityManager.merge(theEmployee);

        //return the db employee
        return dbEmployee;

    }

    @Override
    public void deleteById(int Id) {

        //find employee by id
        Employee theEmployee=entityManager.find(Employee.class,Id);

        //remove the employee
        entityManager.remove(theEmployee);

    }
}
