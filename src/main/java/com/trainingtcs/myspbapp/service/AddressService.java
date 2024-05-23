package com.trainingtcs.myspbapp.service;

import com.trainingtcs.myspbapp.entity.Address;
import com.trainingtcs.myspbapp.entity.User;
import com.trainingtcs.myspbapp.repository.AddressRepository;
import com.trainingtcs.myspbapp.response.AddressResponse;
import com.trainingtcs.myspbapp.response.UserResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addrRepo;
    private final ModelMapper mapper;


    public AddressResponse getAddressById(int id) {
        /*
        Optional<Address> optionalAddr = addrRepo.findById(id);
        return optionalAddr.map(addr -> mapper.map(addr, AddressResponse.class)).orElse(null);
         */
        Optional<Address> optionalAddress = addrRepo.findById(id);
        Address address = optionalAddress.get();

        return toAddressResponse.apply(address, address.getUser());
    }

    public List<AddressResponse> getAllAddress() {
        List<Address> addresses = addrRepo.findAll();
        return  addresses.stream().map(addr -> toAddressResponse.apply(addr,addr.getUser())).collect(Collectors.toList());
    }

    public AddressResponse addAddress(Address newAddr) {
        newAddr.setId(0);
        Address address = addrRepo.save(newAddr);

        AddressResponse addrResponse = toAddressResponse.apply(address, address.getUser());
        return addrResponse;
    }

    public List<AddressResponse> findAllByUser(User user) {
        List<Address> address = addrRepo.findByUser(user);
        return address.stream().map((addr) -> toAddressResponse.apply(addr, user)).collect(Collectors.toList());
    }

    public static BiFunction<Address, User, AddressResponse> toAddressResponse = (address, user) -> {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setCity(address.getCity());
        addressResponse.setUserID(user.getId());
        addressResponse.setStreet(address.getStreet());

        return addressResponse;
    };

}

