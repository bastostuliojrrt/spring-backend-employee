package com.javaspring.backend.controller;

import com.javaspring.backend.exception.ResourceNotFoundException;
import com.javaspring.backend.model.Employee;
import com.javaspring.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // get employee by id REST API
    @GetMapping("/employees/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable long id){
        //
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        return ResponseEntity.ok(employee);
    }

    // update employee REST API
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable long id, @RequestBody Employee employeeDetails){
        // find employee by id
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: " + id));

        // update values of employee by employeeDetail's values
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setDepartamentId(employeeDetails.getDepartamentId());
        employee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

}
