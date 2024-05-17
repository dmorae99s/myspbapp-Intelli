package com.trainingtcs.myspbapp.repository;

import com.trainingtcs.myspbapp.entity.Address;
import com.trainingtcs.myspbapp.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByUser(User user);
}
