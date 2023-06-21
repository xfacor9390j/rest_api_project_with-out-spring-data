package com.abhinay.cruddemo.Service;

import com.abhinay.cruddemo.dao.EmployeeDAO;
import com.abhinay.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
   private EmployeeDAO employeeDAO;

   @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDao ) {
       employeeDAO = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findbyId(int Id) {
        return employeeDAO.findbyId(Id);
    }
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(int Id) {
        employeeDAO.deleteById(Id);
    }
}
