package com.trainingtcs.myspbapp.service;

import java.sql.SQLException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.trainingtcs.myspbapp.entity.Address;
import com.trainingtcs.myspbapp.repository.AddressRepository;
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
import org.springframework.transaction.annotation.Transactional;

//when calling a user it should show the multiple addresses and the department

//use transformer instead of map

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final ModelMapper mapper;
    private final AddressService addressService;
    private final AddressRepository addressRepo;

    //TODO: make a correct use of optional
    public UserResponse getUserById(int id) {
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
        userResponse.setUserName(user.getUserName()) ;
        userResponse.setRole(user.getRole());
        //userResponse.setAddresses(user.getAddresses());
        List<AddressResponse> addressResponse =
                user.getAddresses().stream().map(adrr->AddressService.toAddressResponse.apply(adrr, user )).collect(Collectors.toList());
        userResponse.setAddresses(addressResponse);


        return userResponse;
    };

    @Transactional
    public UserResponse addUser(User newUser) {
    	//TODO: make it transactional
    	newUser.setId(0);
        User user = userRepo.save(newUser);
        user.getAddresses().stream().map(addr->{
                    addr.setUser(newUser);
                    return addr;
                }).forEach(address -> addressRepo.save(address)); ;

        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return userResponse;
    }
    
    public UserResponse updateUser(User uptUser) {
    	//TODO: validate user does exist
    	
        User user = userRepo.save(uptUser);
        
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return userResponse;
    }

    public UserResponse deleteUser(int id) {
        userRepo.delete( userRepo.findById(id).get());

        //TODO: send the right responce
        UserResponse userResponse = new UserResponse();
        return userResponse;
    }

}
