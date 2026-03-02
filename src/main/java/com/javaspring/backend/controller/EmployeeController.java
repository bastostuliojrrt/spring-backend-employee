package com.javaspring.backend.controller;

import com.javaspring.backend.model.Employee;
import com.javaspring.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    // create employee REST API
    @PostMapping("/employees")
    public Employee createEmployee (@RequestBody Employee employee){

        return employeeRepository.save(employee);

    }

}
