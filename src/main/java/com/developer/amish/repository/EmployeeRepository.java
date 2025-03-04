package com.developer.amish.repository;

import com.developer.amish.entity.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // CRUD
    // C - Create
    // R- Read
    // U - Update
    // D - Delete

    List<Employee> findByEmail(String email);

    List<Employee> findByAge(int age);

    List<Employee> findByfirstName(String firstname);

    List<Employee> findByPhone(long phone);

    Page findAll(Pageable pageable);

    Page<Employee> searchByFirstName(String firstName, Pageable pageable);
    Page<Employee> searchByLastName(String lastName, Pageable pageable);
}
