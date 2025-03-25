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

//  @ManyToOne
//  @JoinColumn(name = "employee_id")
//    private Employee employee;


//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }   setting it explicitely
//
//    public Employee getEmployee() {
//        return employee;
//    }
}
