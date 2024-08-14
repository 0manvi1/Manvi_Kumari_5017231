package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.Department;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Save or update a department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get all departments
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    // Find department by ID
    public Optional<Department> findDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Delete department by ID
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
