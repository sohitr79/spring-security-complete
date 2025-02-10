package com.example.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;


/**
 * Always make all packages as child of parent package that contaions application main
 * Since @SpringBootApplication this annotation contains @Component scan that will scan for any components
 * that are present either in this package or its child package
 */
@Entity
@Table(name = "meta_info")
@Data
public class MetaInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeName;
    private String departmentName;

    public MetaInfo(String employeeName, String departmentName) {
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }
}
