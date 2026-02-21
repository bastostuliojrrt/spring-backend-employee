package com.javaspring.backend.repository;

import com.javaspring.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Query Methods
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
