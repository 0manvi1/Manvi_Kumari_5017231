//package com.example.EmployeeManagementSystem.repository;
//
//import com.example.EmployeeManagementSystem.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import java.util.List;
//
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    // Derived query method to find employees by name
//    List<Employee> findByName(String name);
//    
//    // Derived query method to find employees by position
//    List<Employee> findByPosition(String position);
//    
// // Custom query method to find employees by department ID
//    List<Employee> findByDepartmentId(Long departmentId);
//}


//package com.example.EmployeeManagementSystem.repository;
//import com.example.EmployeeManagementSystem.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import java.util.List;
//
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//	// Named Query method to find employees by name
//    List<Employee> findByName(String name);
//
//    // Named Query method to find employees by email
//    Employee findByEmail(String email);
//    
//    // Custom JPQL query to find employees by name
//    @Query("SELECT e FROM Employee e WHERE e.name = :name")
//    List<Employee> findEmployeesByName(@Param("name") String name);
//
//    // Custom JPQL query to find employees by email
//    @Query("SELECT e FROM Employee e WHERE e.email = :email")
//    Employee findEmployeeByEmail(@Param("email") String email);
//
//    // Custom JPQL query to find employees by department ID
//    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
//    List<Employee> findEmployeesByDepartmentId(@Param("departmentId") Long departmentId);
//}

//Implementing Pagination and Sorting
package com.example.EmployeeManagementSystem.repository;
import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.projection.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query method to find employees by name
    List<Employee> findByName(String name);

    // Custom query method to find employees by email
    Employee findByEmail(String email);

    // Custom query method to find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Pagination and sorting are handled by default methods in JpaRepository
    Page<Employee> findAll(Pageable pageable);
    
    @Query("SELECT new com.example.EmployeeDTO(e.id, e.name, e.position, e.department.name) " +
            "FROM Employee e")
     List<EmployeeDTO> findEmployeeProjections();
}

