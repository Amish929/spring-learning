package com.developer.amish.service;

import com.developer.amish.entity.Employee;

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
}
