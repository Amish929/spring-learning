package com.developer.amish.service;

import com.developer.amish.entity.Employee;

import java.util.List;


public interface EmployeeService {

    Employee insertEmployee(Employee employee);

    Employee findById(Long empId);

    List<Employee> findByEmail(String email);

}
