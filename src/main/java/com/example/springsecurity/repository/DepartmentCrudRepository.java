package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentCrudRepository extends JpaRepository<Department,Long> {
}
