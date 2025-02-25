package com.developer.amish.service.impl;

import com.developer.amish.entity.Employee;
import com.developer.amish.repository.EmployeeRepository;
import com.developer.amish.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long empId) {
        return this.employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee Not Found with Id: " + empId));

    }

    @Override
    public List<Employee> findByEmail(String email) {
        return this.employeeRepository.findByEmail(email);
    }
}
