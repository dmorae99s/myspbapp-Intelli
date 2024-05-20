package com.trainingtcs.myspbapp.controller;

import com.trainingtcs.myspbapp.response.AddressResponse;
import com.trainingtcs.myspbapp.response.UserResponse;
import com.trainingtcs.myspbapp.service.AddressService;
import com.trainingtcs.myspbapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AddressController {
    private AddressService addressService;

    @GetMapping("/address/all")
    private ResponseEntity<List<AddressResponse>> getAllAddress(){
        List<AddressResponse> address = addressService.getAllAddress();
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }
}
