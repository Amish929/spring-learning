package com.developer.amish.controller;

import com.developer.amish.entity.Employee;
import com.developer.amish.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("")
    public Employee registerEmployee(@RequestBody Employee employee) {
        return this.employeeService.insertEmployee(employee);
    }

    @GetMapping("/{empId}")
    public Employee findEmployeeById(@PathVariable("empId") Long id) {
        return this.employeeService.findById(id);
    }

    @GetMapping("/search/{email}")
    public List<Employee> findEmployeeEmail(@PathVariable("email") String email) {
        return this.employeeService.findByEmail(email);
    }

}
