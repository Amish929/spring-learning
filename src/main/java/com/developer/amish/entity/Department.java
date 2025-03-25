package com.developer.amish.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String depName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
