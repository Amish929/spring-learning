package com.developer.amish.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "emp_id")
    private Employee employee;

}