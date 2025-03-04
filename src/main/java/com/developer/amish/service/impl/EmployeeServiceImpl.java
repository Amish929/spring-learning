package com.developer.amish.service.impl;

import com.developer.amish.entity.Employee;
import com.developer.amish.repository.EmployeeRepository;
import com.developer.amish.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    //predefine function of save in crud repo. we can just change the method name to anything.
    public Employee registerEmployee(Employee employee) {
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
    @Override
    public List<Employee> findByAge(int age){
        return this.employeeRepository.findByAge(age);
    }
    @Override
    public List<Employee> findByfirstName(String firstName){
        return this.employeeRepository.findByfirstName(firstName);
    }
    @Override
    public List<Employee> findByPhone(long phone){
        return this.employeeRepository.findByPhone(phone);
    }
    @Override
    public Employee updateEmail(Long empId, String newEmail) {
        return employeeRepository.findById(empId).map(employee -> {
            employee.setEmail(newEmail);
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    @Override
    public Employee updatephone(long empId, long newphone){
        return employeeRepository.findById(empId).map(employee ->{
            employee.setPhone(newphone);
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    @Override
    public List<Employee> findAll(Employee employee){
        return (List<Employee>) this.employeeRepository.findAll();
    }
    public Page<Employee> getEmployees(int pageNo, int pageSize, String direction, String sortField) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize, Sort.Direction.valueOf(direction), sortField);
        return (Page<Employee>) employeeRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }


@Override
public Page<Employee> searchByFirstName(String firstName, Pageable pageable) {
    return employeeRepository.searchByFirstName(firstName, pageable);
}
@Override
    public Page<Employee> searchByLastName(String lastName, Pageable pageable){
        return this.employeeRepository.searchByLastName(lastName,pageable);
}


}
