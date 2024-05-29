package com.trainingtcs.myspbapp.controller;

import com.trainingtcs.myspbapp.entity.Employee;
import com.trainingtcs.myspbapp.response.EmployeeResponse;
import com.trainingtcs.myspbapp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    /*
    //update an existing user
    @PostMapping("/employees")
    private ResponseEntity<UserResponse> newUser(@RequestBody User newUser){
        UserResponse user = userService.addUser(newUser);


        return ResponseEntity.status(HttpStatus.OK).body(user);

    }

    //update an existing user
    @PutMapping("/users/{Id}")
    private ResponseEntity<UserResponse> updateUser(@RequestBody User uptUser){

        UserResponse user = userService.updateUser(uptUser);
        return ResponseEntity.status(HttpStatus.OK).body(user);

    }

    @DeleteMapping("/users/{Id}")
    private ResponseEntity<UserResponse> updateUser(@PathVariable("Id") int id){

        UserResponse user = userService.deleteUser(id);


        return ResponseEntity.status(HttpStatus.OK).body(user);

    }
     */
}
