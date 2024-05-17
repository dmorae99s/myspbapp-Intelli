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

        return toAddressResponse.apply(optionalAddress.get());
    }

    public List<AddressResponse> getAllAddress() {
        List<Address> addresses = addrRepo.findAll();

        //Optional<List> optionalAddress = addrRepo.findAll());
        //return optionalAddress.stream().map(
        //                (addr) -> mapper.map(addr, AddressResponse.class))
        //        .collect(Collectors.toList());
        return  addresses.stream().map(addr -> toAddressResponse.apply(addr)).collect(Collectors.toList());
    }

    public AddressResponse addAddress(Address newAddr) {
        newAddr.setId(0);
        Address address = addrRepo.save(newAddr);

        AddressResponse addrResponse = toAddressResponse.apply(address);
        return addrResponse;
    }

    public List<AddressResponse> findAllByUser(User user) {
        List<Address> address = addrRepo.findByUser(user);

        return address.stream().map((addr) -> toAddressResponse.apply(addr)).collect(Collectors.toList());
    }

    public static Function<Address, AddressResponse> toAddressResponse= address -> {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setCity(address.getCity());
        addressResponse.setUserID(address.getUser().getId());
        addressResponse.setStreet(address.getStreet());
        //addressResponse.setUser(address.getUser());
        return addressResponse;
    };

}

