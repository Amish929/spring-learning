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

    @OneToMany( mappedBy = "employee", cascade = CascadeType.ALL)

    private List<Project> projects = new ArrayList<>();
}
