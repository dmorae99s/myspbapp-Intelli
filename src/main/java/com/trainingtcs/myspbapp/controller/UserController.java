package com.trainingtcs.myspbapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.trainingtcs.myspbapp.entity.User;
//import com.trainingtcs.myspbapp.entity.User;
import com.trainingtcs.myspbapp.response.UserResponse;
import com.trainingtcs.myspbapp.service.UserService;

@AllArgsConstructor
@RestController
public class UserController {

	private UserService userService;
	
	//one user by ID
	@GetMapping("/users/{Id}")
	private ResponseEntity<UserResponse> getUserDetails(@PathVariable("Id") int id){
		UserResponse user = userService.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping("/")
	private String getGreetings(){
		
		return "Hi, try URL http://localhost:8080/users/all or http://localhost:8080/users/{id} ";
	}
	
	//all users
	
	@GetMapping("/users/all")
	private ResponseEntity<List<UserResponse>> getAllUsers(){
		List<UserResponse> users = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	//creating a user
	@PostMapping("/users")
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


}
