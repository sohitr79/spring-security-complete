package com.example.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;


/**
 * Always make all packages as child of parent package that contaions application main
 * Since @SpringBootApplication this annotation contains @Component scan that will scan for any components
 * that are present either in this package or its child package
 */
@Entity
@Table(name = "emp2")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "mobile")
    private Integer mobile;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "departmentId")
    private Department department;
}
