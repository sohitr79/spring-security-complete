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

    // Will add this endpoint when we do role based auth
//    @GetMapping("/all")
//    public ResponseEntity<List<Employee>> getAllEmployee() {
//        List<Employee> EmployeeList = employeeService.getAllEmployee();
//        return ResponseEntity.ok(EmployeeList);
//    }

    //Employee should be able to access his info
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
//
//        Employee Employee = employeeService.getEmployeeById(id);
//        return ResponseEntity.ok(Employee);
//    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {

        Employee Employee = employeeService.getByName(name);
        return ResponseEntity.ok(Employee);
    }

    //Employee should be able to delete his info
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable long id) {
        Employee deletedEmployee = employeeService.deleteEmployeeById(id);
        return ResponseEntity.accepted().body(deletedEmployee);
    }

    //Employee should be able to update his info
    @PutMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee Employee) {
        employeeService.addEmployee(Employee);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
