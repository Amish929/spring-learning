package com.developer.amish.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    private int age;
    private long phone;


    //private String  setEmail;

//    public void setEmail(String newEmail) {
//    }

    public void setEmail(String email) {
       this.email = email;
   }


    public void setPhone(long phone) {
        this.phone = phone;
    }

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

   @OneToMany( cascade = CascadeType.ALL)
   @JoinColumn(name = "employee_id")  // i have set it in one direction mapping making one as owner of relationship
    private List<Project> projects;

//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//        for (Project project : projects) {
//            project.setEmployee(this);  // Important step to set the employee reference
//        } setting of explicity for one to many
//    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> department;
}



