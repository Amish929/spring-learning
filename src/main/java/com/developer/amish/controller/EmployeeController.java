package com.developer.amish.controller;

import com.developer.amish.entity.Employee;
import com.developer.amish.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("")
    
    public Employee registerEmployee( @Valid @RequestBody Employee employee) {
        return this.employeeService.registerEmployee(employee);
    }

    @GetMapping("/{empId}")
    public Employee findEmployeeById(@PathVariable("empId") Long id) {
        return this.employeeService.findById(id);
    }

    @GetMapping("/by-email/{email}")
    public List<Employee> findEmployeeEmail(@PathVariable("email") String email) {
        return this.employeeService.findByEmail(email);
    }
    @GetMapping("/by-age/{age}")
    public List<Employee> findByAge(@PathVariable("age") int age){
        return this.employeeService.findByAge(age);
    }
    @GetMapping("/by-name/{firstName}")
    public List<Employee> findByfirstName(@PathVariable("firstName") String firstname){
        return this.employeeService.findByfirstName(firstname);
    }
    @GetMapping("/by-phone/{phone}")
    public List<Employee> findByPhone(@PathVariable("phone") long phone){
        return this.employeeService.findByPhone(phone);
    }

@PutMapping("/{empId}/email")
public ResponseEntity<String> updateEmployeeEmail(@PathVariable Long empId, @Valid @RequestBody Map<String, String> request) {
    try {
        employeeService.updateEmail(empId, request.get("email"));
        return ResponseEntity.ok("Email updated successfully");
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
@PutMapping("{empId}/phone")
    public ResponseEntity<String> updatephone(@PathVariable Long empId, @RequestBody Map<String, Long> request) {


    try {
        employeeService.updatephone(empId, request.get("phone"));
        return ResponseEntity.ok("Phone is updated Successfully");

    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
@GetMapping("/get-employees")
    public List<Employee> findAll(Employee employee){
        return (List<Employee>) this.employeeService.findAll(employee);
}
@GetMapping("/page-implementation")
public ResponseEntity<Page<Employee>> getProducts(
        @RequestParam(defaultValue = "0") int pageNo,
        @RequestParam(defaultValue = "0") int pageSize,
        @RequestParam(defaultValue = "ASC") String direction, //for ascending we have to pass ASC and for decending DESC
        @RequestParam(defaultValue = "empId") String sortField){

    Page<Employee> products = employeeService.getEmployees(pageNo, pageSize,direction,sortField);
    return ResponseEntity.ok(products);
}


    @GetMapping("/search-by-firstName")
    public Page<Employee> searchByFirstName(@RequestParam String firstName, Pageable pageable) {
        return employeeService.searchByFirstName(firstName, pageable);
    }
    @GetMapping("/search-by-lastName")
    public  Page<Employee> searchByLastName(@RequestParam String lastName,  Pageable pageable){
        return this.employeeService.searchByLastName(lastName,pageable);
    }
    @DeleteMapping("{empId}")
    public void deleteById(@PathVariable("empId") Long empId){
        this.employeeService.deleteById(empId);

    }
}

