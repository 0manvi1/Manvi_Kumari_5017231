package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.Department;
import com.example.EmployeeManagementSystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	 @Autowired
	    private DepartmentService departmentService;

	    // Create a new department
	    @PostMapping
	    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
	        Department savedDepartment = departmentService.saveDepartment(department);
	        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	    }

	    // Get all departments
	    @GetMapping
	    public ResponseEntity<List<Department>> getAllDepartments() {
	        List<Department> departments = departmentService.findAllDepartments();
	        return new ResponseEntity<>(departments, HttpStatus.OK);
	    }

	    // Get department by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
	        Optional<Department> department = departmentService.findDepartmentById(id);
	        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Update an existing department
	    @PutMapping("/{id}")
	    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
	        department.setId(id);
	        Department updatedDepartment = departmentService.saveDepartment(department);
	        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
	    }

	    // Delete a department
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
	        departmentService.deleteDepartment(id);
	        return ResponseEntity.noContent().build();
	    }
}
