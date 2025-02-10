package com.example.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dept")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId")
    private Long departmentId;

    @Column(name = "name")
    private String name;
}
