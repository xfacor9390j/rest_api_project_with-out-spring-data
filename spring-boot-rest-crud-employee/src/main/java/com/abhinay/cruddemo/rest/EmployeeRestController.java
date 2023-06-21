package com.abhinay.cruddemo.rest;

import com.abhinay.cruddemo.Service.EmployeeService;
import com.abhinay.cruddemo.dao.EmployeeDAO;
import com.abhinay.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //quick and dirty: inject employee dao
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService) {
        employeeService = theemployeeService;
    }


    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee employeeById(@PathVariable int id){
        Employee theEmployee=employeeService.findbyId(id);
        if(theEmployee==null){
            throw new RuntimeException("employee id not found");
        }
        return theEmployee;
    }

    //add post method for adding the new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;

    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeid}")
    public String deleteEmployee(@PathVariable int employeeid){
        Employee tempEmployee=employeeService.findbyId(employeeid);
       if(tempEmployee==null){
           throw new RuntimeException("employee not found");
       }
       employeeService.deleteById(employeeid);
       return "employee deleted";

    }
}
