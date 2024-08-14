package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
public interface EmployeeServiceInterface {
	 // Save or update an employee
    Employee saveEmployee(Employee employee);

    // Find all employees with pagination
    Page<Employee> findAllEmployees(Pageable pageable);

    // Find employee by ID
    Optional<Employee> findEmployeeById(Long id);

    // Delete an employee by ID
    void deleteEmployee(Long id); 
}
