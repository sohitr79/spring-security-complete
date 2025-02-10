package com.example.springsecurity.service;

import com.example.springsecurity.custom.exception.BusinessException;
import com.example.springsecurity.custom.exception.EmptyInputException;
import com.example.springsecurity.custom.exception.EmptyListException;
import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.entity.MetaInfo;
import com.example.springsecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentService departmentService;

    @Transactional
    public Employee addEmployee(Employee employee) {
        validateEmployee(employee);

        //First save the Department then save employee

        departmentService.saveDepartmentWithTransaction(employee.getDepartment());


        Employee createdEmployee = employeeRepository.save(employee);

        MetaInfo metaInfo = new MetaInfo(employee.getName(), employee.getDepartment().getName());

        departmentService.saveMetaInfo(metaInfo);

        return createdEmployee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> EmployeeList = employeeRepository.findAll();
        if (EmployeeList.isEmpty()) {
            throw new EmptyListException("602", "There are no records in the database");
        }
        return EmployeeList;
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.getReferenceById((id));
    }

    @Override
    public Employee deleteEmployeeById(long id) {
        Employee deletedEmployee = employeeRepository.getReferenceById(id);
        employeeRepository.delete(deletedEmployee);
        return deletedEmployee;
    }



    private void validateEmployee(Employee employee) {

        if (employee.getName() == null || employee.getName().isBlank()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        if (employeeRepository.findByMobile(employee.getMobile()).isPresent()) {
            throw new BusinessException("408","Already registered Mobile Number");
        }
    }
}
