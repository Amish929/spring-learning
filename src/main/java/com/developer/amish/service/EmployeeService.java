package com.developer.amish.service;

import com.developer.amish.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface EmployeeService {

    Employee registerEmployee(Employee employee);

    Employee findById(Long empId);

    List<Employee> findByEmail(String email);

    List<Employee> findByAge(int age);
    List<Employee> findByfirstName(String firstName);
    List<Employee> findByPhone(long phone);


    Employee updateEmail(Long empId, String email);
    Employee updatephone(long empId, long phone);
   List<Employee>  findAll(Employee employee);

    Page<Employee> getEmployees(int pageNo, int pageSize, String sortField, String direction);

   Page<Employee> searchByFirstName(String firstName, Pageable pageable);
   Page<Employee> searchByLastName(String lastName,Pageable pageable);
}
