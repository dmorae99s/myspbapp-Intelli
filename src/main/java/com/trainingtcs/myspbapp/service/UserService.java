package com.trainingtcs.myspbapp.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import com.trainingtcs.myspbapp.entity.User;
import com.trainingtcs.myspbapp.repository.UserRepository;
import com.trainingtcs.myspbapp.response.UserResponse;


public class UserService {
	
	@Autowired
    private UserRepository userRepo;
 
    @Autowired
    private ModelMapper mapper;
 
    public UserResponse getUserById(int id) {
    	
        Optional<User> user = userRepo.findById(id);
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return userResponse;
    }
    
    
    public List<UserResponse> getAllUsers() {
    	//Optional<List> users = Optional.of(userRepo.findAll());
    	List<User> users = userRepo.findAll();
        if(users != null ) {
        	
        	return users.stream().map(
            		(user) -> mapper.map(user, UserResponse.class))
                    .collect(Collectors.toList());
        }
        
        return null;
        
    }
    
    public UserResponse addUser(User newUser) {
    	//TODO: validate user doesn't exist 
    	newUser.setId(0);
        User user = userRepo.save(newUser);
        
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return userResponse;
    }
    
    public UserResponse updateUser(User uptUser) {
    	//TODO: validate user does exist
    	
        User user = userRepo.save(uptUser);
        
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return userResponse;
    }
    


}
