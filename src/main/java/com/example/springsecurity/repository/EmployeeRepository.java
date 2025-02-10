package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByMobile(Integer mobile);
    Optional<Employee> findByName(String name);
}
