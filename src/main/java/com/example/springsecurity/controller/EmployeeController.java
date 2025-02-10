package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bank/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

       Employee createdEmployee = employeeService.addEmployee(employee);
       URI uri = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(createdEmployee.getId())
               .toUri();
        return ResponseEntity.created(uri).body(createdEmployee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> EmployeeList = employeeService.getAllEmployee();
        return ResponseEntity.ok(EmployeeList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {

        Employee Employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(Employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable long id) {
        Employee deletedEmployee = employeeService.deleteEmployeeById(id);
        return ResponseEntity.accepted().body(deletedEmployee);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee Employee) {
        employeeService.addEmployee(Employee);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
