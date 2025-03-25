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
    private int depId;
    private String depName;
   @ManyToMany(mappedBy = "department")
    private List<Employee> employees;
}
