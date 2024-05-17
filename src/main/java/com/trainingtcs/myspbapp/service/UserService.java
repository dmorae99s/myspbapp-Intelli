package com.trainingtcs.myspbapp.service;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.trainingtcs.myspbapp.response.AddressResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import com.trainingtcs.myspbapp.entity.User;
import com.trainingtcs.myspbapp.repository.UserRepository;
import com.trainingtcs.myspbapp.response.UserResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//with component we replace the need of bean in configuration, note bean is used in third party classes
//Service annotation is for service...

//fotr friday make a call, 1 hour, users to be part of diferent departments and user can have multiple address
//when calling a user it should show the multiple addresses and the department

//use transformer instead of map

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final ModelMapper mapper;

    //TODO: make a correct use of optional
    public UserResponse getUserById(int id) {
        //Optional<User> optionalUser = userRepo.findById(id);
        //return optionalUser.map(user -> mapper.map(user, UserResponse.class)).orElse(null);

        return toUserResponse.apply(userRepo.findById(id).orElse(null));
    }

    public List<UserResponse> getAllUsers() {
    	List<User> users = userRepo.findAll();
    	return users.stream().map(
            		(user) -> toUserResponse.apply(user) ).collect(Collectors.toList());

        
    }
    public static Function<User, UserResponse> toUserResponse= user -> {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getUserName());
        //userResponse.setAddresses(user.getAddresses());
        List<AddressResponse> addressResponse =
                user.getAddresses().stream().map(adrr->AddressService.toAddressResponse.apply(adrr, user )).collect(Collectors.toList());
        userResponse.setAddresses(addressResponse);


        return userResponse;
    };

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
