package com.example.springsecurity.service;

import com.example.springsecurity.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
   Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(long id);

    Employee deleteEmployeeById(long id);
}
