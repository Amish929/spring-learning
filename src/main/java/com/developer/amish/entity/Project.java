package com.developer.amish.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

   @ManyToOne
    @JoinColumn(name = "project_id")
    private Employee employee;


}
