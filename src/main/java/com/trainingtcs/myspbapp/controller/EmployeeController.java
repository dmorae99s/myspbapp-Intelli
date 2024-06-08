package com.trainingtcs.myspbapp.controller;

import com.trainingtcs.myspbapp.entity.Employee;
import com.trainingtcs.myspbapp.response.EmployeeResponse;
import com.trainingtcs.myspbapp.response.HRPaymentsResponse;
import com.trainingtcs.myspbapp.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/employees/{Id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("Id") int id){
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping("/employees")
    private String getGreetings(){

        return "Hi, try URL http://localhost:8080/employees/all or http://localhost:8080/employees/{id} ";
    }

    @GetMapping("/employeesmap")
    private ResponseEntity<Map<String, List<Employee>>> getEmployeesMap(){
        Map<String, List<Employee>> empMap = employeeService.getMapEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(empMap);
    }

    @GetMapping("/employees/all")
    private ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        List<EmployeeResponse> employees = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/employees/payments/{empId}")
    private ResponseEntity<List<HRPaymentsResponse>> getEmployeePayments(@PathVariable("empId") int empId){
        List<HRPaymentsResponse> hrPaymentsResponseList = employeeService.getEmployeePaymentsByEmpId(empId);
        return ResponseEntity.status(HttpStatus.OK).body(hrPaymentsResponseList);
    }




}
