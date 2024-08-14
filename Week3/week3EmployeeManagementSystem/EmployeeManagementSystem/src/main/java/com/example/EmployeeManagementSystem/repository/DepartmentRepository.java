package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	// Named Query method to find department by name
    @Query(name = "Department.findByName")
    Optional<Department> findByName(String name);
}