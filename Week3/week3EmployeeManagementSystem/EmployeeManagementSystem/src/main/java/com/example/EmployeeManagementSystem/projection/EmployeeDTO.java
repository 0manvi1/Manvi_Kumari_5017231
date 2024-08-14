package com.example.EmployeeManagementSystem.projection;

public class EmployeeDTO {
	private Long id;
    private String name;
    private String position;
    private String departmentName;

    public EmployeeDTO(Long id, String name, String position, String departmentName) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.departmentName = departmentName;
    }
    //getters
}
