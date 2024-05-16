package com.trainingtcs.myspbapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingtcs.myspbapp.entity.User;

//
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
}
