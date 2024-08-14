//package com.example.EmployeeManagementSystem.service;
//
//import com.example.EmployeeManagementSystem.Employee;
//import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeService {
//	 @Autowired
//	    private EmployeeRepository employeeRepository;
//
//	    // Save or update an employee
//	    public Employee saveEmployee(Employee employee) {
//	        return employeeRepository.save(employee);
//	    }
//
//	    // Get all employees
//	    public List<Employee> findAllEmployees() {
//	        return employeeRepository.findAll();
//	    }
//
//	    // Find employee by ID
//	    public Optional<Employee> findEmployeeById(Long id) {
//	        return employeeRepository.findById(id);
//	    }
//
//	    // Delete employee by ID
//	    public void deleteEmployee(Long id) {
//	        employeeRepository.deleteById(id);
//	    }
//}


//Implementing Pagination and Sorting
//package com.example.EmployeeManagementSystem.service;
//
//import com.example.EmployeeManagementSystem.Employee;
//import org.springframework.transaction.annotation.Transactional;
//import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import jakarta.persistence.*;
//import java.util.List;
//import java.util.Optional;

package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // Save or update an employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees with pagination
    public Page<Employee> findAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    // Find employee by ID
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void saveEmployeesInBatch(List<Employee> employees) {
        int batchSize = 30; // Set this to match your configured batch size
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                // Flush a batch of inserts and release memory
                entityManager.flush();
                entityManager.clear();
            }
        }
        // Flush remaining entities
        entityManager.flush();
        entityManager.clear();
    }

}
