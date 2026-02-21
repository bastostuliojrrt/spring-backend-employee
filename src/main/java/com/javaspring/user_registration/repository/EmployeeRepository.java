package com.javaspring.user_registration.repository;

import com.javaspring.user_registration.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Query Methods
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
